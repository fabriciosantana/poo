#!/usr/bin/env bash

set -euo pipefail

usage() {
  cat <<'EOF'
Uso:
  scripts/update-fork.sh [opcoes]

Opcoes:
  -B, --branch BRANCH   Branch para sincronizar (padrao: branch HEAD do upstream)
      --no-push         Nao faz push para origin ao final
  -h, --help            Mostra esta ajuda

Exemplos:
  scripts/update-fork.sh
  scripts/update-fork.sh -B main
  scripts/update-fork.sh -B master --no-push
EOF
}

err() {
  echo "Erro: $*" >&2
  exit 1
}

require_cmd() {
  command -v "$1" >/dev/null 2>&1 || err "comando '$1' nao encontrado"
}

detect_upstream_default_branch() {
  local branch
  branch="$(git remote show upstream 2>/dev/null | sed -n '/HEAD branch/s/.*: //p' | tr -d '\r')"
  if [[ -n "$branch" ]]; then
    echo "$branch"
    return 0
  fi

  if git show-ref --verify --quiet refs/remotes/upstream/main; then
    echo "main"
    return 0
  fi

  if git show-ref --verify --quiet refs/remotes/upstream/master; then
    echo "master"
    return 0
  fi

  err "nao foi possivel detectar a branch padrao do upstream (use -B/--branch)"
}

BRANCH=""
DO_PUSH=true

while [[ $# -gt 0 ]]; do
  case "$1" in
    -B|--branch)
      [[ $# -ge 2 ]] || err "faltou valor para $1"
      BRANCH="$2"
      shift 2
      ;;
    --no-push)
      DO_PUSH=false
      shift
      ;;
    -h|--help)
      usage
      exit 0
      ;;
    *)
      err "opcao invalida: $1 (use --help)"
      ;;
  esac
done

require_cmd git
git rev-parse --is-inside-work-tree >/dev/null 2>&1 || err "execute dentro de um repositorio git"

git remote get-url origin >/dev/null 2>&1 || err "remote 'origin' nao encontrado"
git remote get-url upstream >/dev/null 2>&1 || err "remote 'upstream' nao encontrado"

if [[ -z "$BRANCH" ]]; then
  BRANCH="$(detect_upstream_default_branch)"
fi

if [[ -n "$(git status --porcelain)" ]]; then
  err "working tree com alteracoes. Faça commit/stash antes de sincronizar"
fi

CURRENT_BRANCH="$(git branch --show-current)"

echo "Buscando atualizacoes do upstream..."
git fetch upstream

if ! git show-ref --verify --quiet "refs/remotes/upstream/$BRANCH"; then
  err "branch 'upstream/$BRANCH' nao encontrada"
fi

if git show-ref --verify --quiet "refs/heads/$BRANCH"; then
  git checkout "$BRANCH"
else
  git checkout -b "$BRANCH" --track "origin/$BRANCH" 2>/dev/null || git checkout -b "$BRANCH" --track "upstream/$BRANCH"
fi

echo "Sincronizando $BRANCH com upstream/$BRANCH (fast-forward)..."
git merge --ff-only "upstream/$BRANCH"

if [[ "$DO_PUSH" == true ]]; then
  echo "Enviando $BRANCH para origin..."
  git push origin "$BRANCH"
fi

if [[ -n "$CURRENT_BRANCH" && "$CURRENT_BRANCH" != "$BRANCH" ]]; then
  git checkout "$CURRENT_BRANCH"
fi

echo "Fork atualizado com sucesso."
