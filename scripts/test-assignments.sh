#!/bin/bash

# Diretório base para as tarefas
BASE_DIR="assignments"
JUNIT_VERSION="1.11.4"
JUNIT_JAR="test-libs/junit-platform-console-standalone-${JUNIT_VERSION}.jar"
TEST_FAILURES=0

# Solicita a tarefa a ser testada uma única vez (aceita caminho parcial)
read -r -p "Digite o diretório da tarefa (ou pressione Enter para testar todas): " TASK_FILTER

# Lista todos os diretórios de submissions em qualquer nível de profundidade
mapfile -t SUBMISSIONS_DIRS < <(find "$BASE_DIR" -type d -name submissions | sort)

if [ ${#SUBMISSIONS_DIRS[@]} -eq 0 ]; then
    echo "❌ Erro: nenhum diretório 'submissions' encontrado em '$BASE_DIR'."
    exit 1
fi

# Se não for informado, roda todas as tarefas disponíveis
if [ -z "$TASK_FILTER" ]; then
    echo "🔎 Nenhuma tarefa específica informada. Buscando todas as tarefas disponíveis..."
    TASKS=()
    for SUBMISSIONS_DIR in "${SUBMISSIONS_DIRS[@]}"; do
        TASKS+=("${SUBMISSIONS_DIR%/submissions}")
    done
else
    TASKS=()
    for SUBMISSIONS_DIR in "${SUBMISSIONS_DIRS[@]}"; do
        TASK_DIR="${SUBMISSIONS_DIR%/submissions}"
        TASK_REL="${TASK_DIR#$BASE_DIR/}"
        if [[ "$TASK_REL" == "$TASK_FILTER" ]] || [[ "$TASK_REL" == *"$TASK_FILTER"* ]]; then
            TASKS+=("$TASK_DIR")
        fi
    done
fi

# Solicita o aluno a ser testado uma única vez
read -r -p "Digite o diretório do aluno (ou pressione Enter para testar todos): " STUDENT_FILTER

if [ ${#TASKS[@]} -eq 0 ]; then
    echo "❌ Erro: nenhuma tarefa encontrada para o filtro informado."
    exit 1
fi

# Baixa dependência do JUnit uma vez para toda a execução
if [ ! -f "$JUNIT_JAR" ]; then
    echo "⬇️ Baixando JUnit ${JUNIT_VERSION}..."
    mkdir -p "$(dirname "$JUNIT_JAR")"
    curl -L -o "$JUNIT_JAR" \
         "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/${JUNIT_VERSION}/junit-platform-console-standalone-${JUNIT_VERSION}.jar"
fi

# Itera sobre todas as tarefas selecionadas
for TASK in "${TASKS[@]}"; do
    TASK_NAME="${TASK#$BASE_DIR/}"

    # Verifica se o diretório da tarefa realmente existe
    if [ ! -d "$TASK" ]; then
        echo "⚠️  Aviso: O diretório da tarefa '$TASK_NAME' não existe! Pulando..."
        continue
    fi

    # Diretório de submissões
    SUBMISSIONS_DIR="$TASK/submissions"

    # Se não existir submissões para essa tarefa, pula para a próxima
    if [ ! -d "$SUBMISSIONS_DIR" ]; then
        echo "⚠️  Aviso: Nenhuma submissão encontrada para a tarefa '$TASK_NAME'. Pulando..."
        continue
    fi

    # Define a lista de alunos a testar
    if [ -z "$STUDENT_FILTER" ]; then
        echo "📂 Nenhum aluno específico informado. Testando todas as submissões para '$TASK_NAME'."
        mapfile -t STUDENTS < <(find "$SUBMISSIONS_DIR" -mindepth 1 -maxdepth 1 -type d | sort)
    else
        # Valida se o diretório do aluno existe
        if [ ! -d "$SUBMISSIONS_DIR/$STUDENT_FILTER" ]; then
            echo "⚠️  Aviso: O diretório do aluno '$STUDENT_FILTER' não existe para a tarefa '$TASK_NAME'! Pulando..."
            continue
        fi
        STUDENTS=("$SUBMISSIONS_DIR/$STUDENT_FILTER")
    fi

    if [ ${#STUDENTS[@]} -eq 0 ]; then
        echo "⚠️  Aviso: Nenhuma submissão de aluno encontrada para '$TASK_NAME'. Pulando..."
        continue
    fi

    # Loop para testar cada submissão de aluno
    for STUDENT in "${STUDENTS[@]}"; do
        STUDENT_NAME=$(basename "$STUDENT")
        echo "🚀 Executando testes para a tarefa '$TASK_NAME' do aluno '$STUDENT_NAME'..."

        # Diretório onde os arquivos estão
        CODE_DIR="$STUDENT/src"

        # Verifica se o código-fonte existe
        if [ ! -d "$CODE_DIR" ]; then
            echo "⚠️  Aviso: Nenhum código-fonte encontrado em '$CODE_DIR'. Pulando..."
            continue
        fi

        TEST_DIR="$TASK/test"
        if [ ! -d "$TEST_DIR" ]; then
            echo "⚠️  Aviso: Nenhum diretório de testes encontrado em '$TEST_DIR'. Pulando..."
            continue
        fi

        mapfile -t CODE_FILES < <(find "$CODE_DIR" -type f -name "*.java" | sort)
        mapfile -t TEST_FILES < <(find "$TEST_DIR" -type f -name "*.java" | sort)

        if [ ${#CODE_FILES[@]} -eq 0 ]; then
            echo "⚠️  Aviso: Nenhum arquivo .java encontrado em '$CODE_DIR'. Pulando..."
            continue
        fi

        if [ ${#TEST_FILES[@]} -eq 0 ]; then
            echo "⚠️  Aviso: Nenhum teste .java encontrado em '$TEST_DIR'. Pulando..."
            continue
        fi

        # Diretório de compilação
        BIN_DIR="$STUDENT/bin"
        mkdir -p "$BIN_DIR"

        # Compila os arquivos
        if ! javac -cp "$JUNIT_JAR" -d "$BIN_DIR" "${CODE_FILES[@]}" "${TEST_FILES[@]}"; then
            echo "❌ Erro na compilação da tarefa '$TASK_NAME' do aluno '$STUDENT_NAME'."
            TEST_FAILURES=$((TEST_FAILURES + 1))
            continue
        fi

        # Executa os testes
        if ! java -jar "$JUNIT_JAR" execute --class-path "$BIN_DIR" --scan-class-path; then
            echo "❌ Falha nos testes da tarefa '$TASK_NAME' do aluno '$STUDENT_NAME'."
            TEST_FAILURES=$((TEST_FAILURES + 1))
            continue
        fi

        echo "✅ Testes bem-sucedidos para '$TASK_NAME' / '$STUDENT_NAME'."
    done
done

if [ "$TEST_FAILURES" -gt 0 ]; then
    echo "❌ Execução finalizada com $TEST_FAILURES falha(s)."
    exit 1
fi

echo "✅ Execução dos testes finalizada sem falhas!"
