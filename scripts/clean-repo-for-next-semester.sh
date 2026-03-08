#!/bin/bash
set -euo pipefail

# Diretório base do repositório
BASE_DIR="$(pwd)"

echo "🧹 Limpando diretórios submissions em assignments/ (mantendo .gitkeep)..."
if [ -d "${BASE_DIR}/assignments" ]; then
  find "${BASE_DIR}/assignments" -type d -name submissions | while read -r submission_dir; do
    find "$submission_dir" -mindepth 1 -not -name ".gitkeep" -exec rm -rf {} +
  done
fi

echo "🧹 Limpando binários temporários de submissões em assignments/..."
if [ -d "${BASE_DIR}/assignments" ]; then
  find "${BASE_DIR}/assignments" -type d -name bin -exec rm -rf {} +
fi

echo "✅ Limpeza concluída para a estrutura atual do repositório."
