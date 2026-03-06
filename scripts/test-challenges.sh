#!/bin/bash
set -euo pipefail

# Diretório base dos projetos (ancorado no diretório deste script)
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
BASE_DIR="$SCRIPT_DIR/../assignments/06-projects"

# Solicita a tarefa a ser testada uma única vez
read -p "Digite o diretório da tarefa (ou pressione Enter para testar todas): " TASK_DIR

# Se não for informado, roda todas as tarefas disponíveis
if [ -z "$TASK_DIR" ]; then
    echo "🔎 Nenhuma tarefa específica informada. Buscando todas as tarefas disponíveis..."
    TASKS=($(ls -d "$BASE_DIR"/*/ 2>/dev/null))
else
    TASKS=("$BASE_DIR/$TASK_DIR/")
fi

# Solicita o aluno a ser testado uma única vez
read -p "Digite o diretório do aluno (ou pressione Enter para testar todos): " STUDENT_DIR

# Itera sobre todas as tarefas selecionadas
for TASK in "${TASKS[@]}"; do
    TASK_NAME=$(basename "$TASK")

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
    if [ -z "$STUDENT_DIR" ]; then
        echo "📂 Nenhum aluno específico informado. Testando todas as submissões para '$TASK_NAME'."
        STUDENTS=($(ls -d $SUBMISSIONS_DIR/*/ 2>/dev/null))
    else
        # Valida se o diretório do aluno existe
        if [ ! -d "$SUBMISSIONS_DIR/$STUDENT_DIR" ]; then
            echo "⚠️  Aviso: O diretório do aluno '$STUDENT_DIR' não existe para a tarefa '$TASK_NAME'! Pulando..."
            continue
        fi
        STUDENTS=("$SUBMISSIONS_DIR/$STUDENT_DIR/")
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

        # Diretório de compilação
        BIN_DIR="$STUDENT/bin"
        mkdir -p "$BIN_DIR"
        
        # Baixa dependências (caso necessário)
        mkdir -p "$STUDENT/lib"
        curl -L -o "$STUDENT/lib/junit-platform-console-standalone-1.11.4.jar" \
             https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
        curl -L -o "$STUDENT/lib/postgresql-42.7.8.jar" \
             https://jdbc.postgresql.org/download/postgresql-42.7.8.jar
        
        # Compila os arquivos
        javac -cp "$STUDENT/lib/*" -d "$BIN_DIR" "$CODE_DIR"/*.java "$TASK/test"/*.java

        # Executa os testes
        java -cp "$STUDENT/lib/junit-platform-console-standalone-1.11.4.jar:$BIN_DIR:$STUDENT/lib/*" \
             org.junit.platform.console.ConsoleLauncher \
             execute \
             --scan-class-path
    done
done

echo "✅ Execução dos testes finalizada!"
