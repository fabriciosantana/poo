#!/bin/bash

# Diretório base para os desafios
BASE_DIR="challenges"

# Solicita o desafio a ser testado
read -p "Digite o diretório do desafio (ou pressione Enter para testar todas): " CHALLENGE_DIR

# Se não for informado, roda todas os desafios disponíveis
if [ -z "$CHALLENGE_DIR" ]; then
    echo "🔎 Nenhum desafio específico informada. Buscando todas os desafios disponíveis..."
    CHALLENGES=($(ls -d $BASE_DIR/*/ 2>/dev/null))
else
    CHALLENGES=("$BASE_DIR/$CHALLENGE_DIR/")
fi

# Itera sobre todas os desafios selecionados
for CHALLENGE in "${CHALLENGES[@]}"; do
    CHALLENGE_NAME=$(basename "$CHALLENGE")

    # Verifica se o diretório da tarefa realmente existe
    if [ ! -d "$CHALLENGE" ]; then
        echo "⚠️  Aviso: O diretório do desafio '$CHALLENGE_NAME' não existe! Pulando..."
        continue
    fi

    # Diretório onde os arquivos estão
    CODE_DIR="$CHALLENGE/src"

    # Verifica se o código-fonte existe
    if [ ! -d "$CODE_DIR" ]; then
        echo "⚠️  Aviso: Nenhum código-fonte encontrado em '$CODE_DIR'. Pulando..."
        continue
    fi

    # Diretório de compilação
    BIN_DIR="$CHALLENGE/bin"
    mkdir -p "$BIN_DIR"
    
    # Baixa dependências (caso necessário)
    mkdir -p "$CHALLENGE/lib"
    curl -L -o "$CHALLENGE/lib/junit-platform-console-standalone-1.11.4.jar" \
            https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
    
    # Compila os arquivos
    javac -cp "$CHALLENGE/lib/*" -d "$BIN_DIR" "$CODE_DIR"/*.java "$CHALLENGE/test"/*.java

    # Executa os testes
    java -jar "$CHALLENGE/lib/junit-platform-console-standalone-1.11.4.jar" --class-path "$BIN_DIR" --scan-class-path
done

echo "✅ Execução dos testes finalizada!"
