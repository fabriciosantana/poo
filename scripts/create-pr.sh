#!/usr/bin/env bash

set -euo pipefail

usage() {
  cat <<'EOF'
Uso:
  scripts/create-pr.sh [opcoes]

Opcoes:
  -t, --title "TITULO"     Titulo do PR (padrao: "<branch>: atualizacao")
  -b, --body "TEXTO"       Corpo do PR (padrao: gerado automaticamente)
      --body-file ARQUIVO   Arquivo com corpo do PR
  -B, --base BRANCH         Branch base (padrao: detecta automaticamente)
  -H, --head BRANCH         Branch de origem (padrao: branch atual)
      --draft               Cria PR como draft
  -h, --help                Mostra esta ajuda

Exemplos:
  scripts/create-pr.sh
  scripts/create-pr.sh -t "feat: hello world" -b "Entrega atividade 00"
  scripts/create-pr.sh -B main --draft
EOF
}

err() {
  echo "Erro: $*" >&2
  exit 1
}

require_cmd() {
  command -v "$1" >/dev/null 2>&1 || err "comando '$1' nao encontrado"
}

detect_base_branch() {
  local base
  base="$(git remote show origin 2>/dev/null | sed -n '/HEAD branch/s/.*: //p' | tr -d '\r')"
  if [[ -n "$base" ]]; then
    echo "$base"
    return 0
  fi

  if git show-ref --verify --quiet refs/remotes/origin/main; then
    echo "main"
    return 0
  fi

  if git show-ref --verify --quiet refs/remotes/origin/master; then
    echo "master"
    return 0
  fi

  err "nao foi possivel detectar a branch base (use -B/--base)"
}

TITLE=""
BODY=""
BODY_FILE=""
BASE=""
HEAD=""
DRAFT=false

while [[ $# -gt 0 ]]; do
  case "$1" in
    -t|--title)
      [[ $# -ge 2 ]] || err "faltou valor para $1"
      TITLE="$2"
      shift 2
      ;;
    -b|--body)
      [[ $# -ge 2 ]] || err "faltou valor para $1"
      BODY="$2"
      shift 2
      ;;
    --body-file)
      [[ $# -ge 2 ]] || err "faltou valor para $1"
      BODY_FILE="$2"
      shift 2
      ;;
    -B|--base)
      [[ $# -ge 2 ]] || err "faltou valor para $1"
      BASE="$2"
      shift 2
      ;;
    -H|--head)
      [[ $# -ge 2 ]] || err "faltou valor para $1"
      HEAD="$2"
      shift 2
      ;;
    --draft)
      DRAFT=true
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
require_cmd gh

git rev-parse --is-inside-work-tree >/dev/null 2>&1 || err "execute dentro de um repositorio git"

if ! gh auth status >/dev/null 2>&1; then
  err "gh nao autenticado. Execute: gh auth login"
fi

CURRENT_BRANCH="$(git branch --show-current)"
[[ -n "$CURRENT_BRANCH" ]] || err "nao foi possivel detectar a branch atual"

if [[ -z "$HEAD" ]]; then
  HEAD="$CURRENT_BRANCH"
fi

if [[ -z "$BASE" ]]; then
  BASE="$(detect_base_branch)"
fi

if [[ -z "$TITLE" ]]; then
  TITLE="$HEAD: atualizacao"
fi

if ! git ls-remote --exit-code --heads origin "$HEAD" >/dev/null 2>&1; then
  err "branch '$HEAD' ainda nao foi enviada para origin. Execute: git push -u origin $HEAD"
fi

if gh pr view "$HEAD" >/dev/null 2>&1; then
  err "ja existe PR aberto para a branch '$HEAD'"
fi

args=(pr create --base "$BASE" --head "$HEAD" --title "$TITLE")

if [[ -n "$BODY_FILE" ]]; then
  [[ -f "$BODY_FILE" ]] || err "arquivo nao encontrado: $BODY_FILE"
  args+=(--body-file "$BODY_FILE")
elif [[ -n "$BODY" ]]; then
  args+=(--body "$BODY")
else
  args+=(--fill)
fi

if [[ "$DRAFT" == true ]]; then
  args+=(--draft)
fi

echo "Criando PR: $HEAD -> $BASE"
gh "${args[@]}"
