# Checklist Operacional de PRs (2026-03)

## Ordem de Merge Sugerida

1. PR-01 `security/examples-placeholders`
2. PR-02 `ci/workflows-current-semester`
3. PR-03 `ops/scripts-repo-layout`
4. PR-04 `docs/root-readme-fixes`
5. PR-05 `assignments/projects-and-collections-readmes`
6. PR-06 `governance/speckit-constitution-and-tracking`

## PR-01 Segurança dos Exemplos

Objetivo: remover dados sensíveis hardcoded.

Arquivos:
- `assignments/04-quizzes/08-exam/Q10.java`
- `assignments/04-quizzes/08-exam/Q12.java`
- `examples/15-jpa/dvdrentalapp/src/main/resources/META-INF/persistence.xml`

Checklist:
- [ ] Trocar URL/usuário/senha por placeholders.
- [ ] Manter exemplos executáveis com configuração local.
- [ ] Validar com `rg` ausência de credenciais reais no escopo do PR.

Critério de aceite:
- [ ] Não há segredo real em arquivos alterados.

## PR-02 CI Workflows do Semestre Atual

Objetivo: alinhar automação à branch e estrutura vigente.

Arquivos:
- `.github/workflows/test-assignments-submissons.yml`
- `.github/workflows/sonar.yml`

Checklist:
- [ ] Ajustar branch de gatilho para `2026.1`.
- [ ] Remover referência a `lectures` inexistente do Sonar.
- [ ] Preservar execução de compilação parcial sem interromper análise.

Critério de aceite:
- [ ] Workflows referenciam apenas caminhos existentes.

## PR-03 Scripts Operacionais

Objetivo: corrigir scripts para layout atual e execução segura.

Arquivos:
- `scripts/test-challenges.sh`
- `scripts/clean-repo-for-next-semester.sh`

Checklist:
- [ ] Migrar paths legados para `assignments/`.
- [ ] Habilitar modo seguro (`set -euo pipefail`) quando aplicável.
- [ ] Evitar erro quando diretório opcional não existir.

Critério de aceite:
- [ ] `bash -n` passa para os scripts alterados.

## PR-04 README Raiz

Objetivo: melhorar navegação e confiabilidade das instruções.

Arquivos:
- `README.md`

Checklist:
- [ ] Atualizar referências de semestre para 2026.
- [ ] Corrigir links locais quebrados.
- [ ] Corrigir typos críticos.

Critério de aceite:
- [ ] Links locais no README resolvem para paths existentes no repositório.

## PR-05 Enunciados de Assignments

Objetivo: remover inconsistências de caminho e lista de projetos.

Arquivos:
- `assignments/06-projects/README.md`
- `assignments/01-programming/07b-collections/README.md`

Checklist:
- [ ] Remover/ajustar itens que apontam para diretórios inexistentes.
- [ ] Corrigir path de submissão com typo.

Critério de aceite:
- [ ] Aluno consegue localizar caminho de entrega sem ambiguidade.

## PR-06 Governança e Rastreabilidade (Speckit)

Objetivo: formalizar governança e rastreabilidade de execução.

Arquivos:
- `.specify/memory/constitution.md`
- `specs/001-repo-quality-hardening/spec.md`
- `specs/001-repo-quality-hardening/plan.md`
- `specs/001-repo-quality-hardening/tasks.md`
- `docs/pr-operational-checklist-2026-03.md`

Checklist:
- [ ] Constitution sem placeholders.
- [ ] Spec/Plan/Tasks consistentes com PR-01..PR-05.
- [ ] Ordem de merge publicada.

Critério de aceite:
- [ ] Artefatos Speckit descrevem e rastreiam as mudanças implementadas.
