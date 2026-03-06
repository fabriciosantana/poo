# Tasks: Repository Quality Hardening

**Input**: Design documents from `/specs/001-repo-quality-hardening/`
**Prerequisites**: plan.md, spec.md

**Tests**: Validação operacional (sintaxe/scripts/paths), sem suíte de testes nova.

## Phase 1: Setup (Shared Infrastructure)

- [ ] T001 Criar checklist operacional de PRs em docs/pr-operational-checklist-2026-03.md
- [ ] T002 Definir constitution do repositório em .specify/memory/constitution.md

---

## Phase 2: Foundational (Blocking Prerequisites)

- [ ] T003 Atualizar artefatos Speckit da feature em specs/001-repo-quality-hardening/spec.md
- [ ] T004 Atualizar plano de implementação em specs/001-repo-quality-hardening/plan.md
- [ ] T005 Gerar tarefas executáveis com rastreabilidade em specs/001-repo-quality-hardening/tasks.md

---

## Phase 3: User Story 1 - Segurança dos Exemplos (Priority: P1)

**Goal**: Remover credenciais reais de exemplos e quizzes JDBC/JPA.
**Independent Test**: `rg` não encontra senha/usuário reais no escopo alterado.

- [ ] T006 [US1] Substituir credenciais por placeholders em assignments/04-quizzes/08-exam/Q10.java
- [ ] T007 [US1] Substituir credenciais por placeholders em assignments/04-quizzes/08-exam/Q12.java
- [ ] T008 [US1] Substituir credenciais por placeholders em examples/15-jpa/dvdrentalapp/src/main/resources/META-INF/persistence.xml

---

## Phase 4: User Story 2 - Automação confiável de avaliação (Priority: P1)

**Goal**: Alinhar workflows/scripts à estrutura ativa do repositório.
**Independent Test**: sintaxe de shell válida e paths/branches existentes.

- [ ] T009 [US2] Atualizar branch alvo no workflow em .github/workflows/test-assignments-submissons.yml
- [ ] T010 [US2] Ajustar caminhos legados no Sonar em .github/workflows/sonar.yml
- [ ] T011 [US2] Corrigir base path de testes de projetos em scripts/test-challenges.sh
- [ ] T012 [US2] Corrigir script de limpeza para estrutura atual em scripts/clean-repo-for-next-semester.sh

---

## Phase 5: User Story 3 - Clareza do conteúdo e navegação (Priority: P2)

**Goal**: Corrigir links quebrados, typos críticos e paths de submissão.
**Independent Test**: links locais válidos + leitura consistente de enunciados.

- [ ] T013 [US3] Corrigir links e texto crítico no README.md
- [ ] T014 [US3] Ajustar lista de projetos para caminhos existentes em assignments/06-projects/README.md
- [ ] T015 [US3] Corrigir path de submissão em assignments/01-programming/07b-collections/README.md

---

## Phase 6: Polish & Cross-Cutting Concerns

- [ ] T016 Executar validação de sintaxe: bash -n scripts/*.sh
- [ ] T017 Executar checagem de links locais e paths citados no README.md
- [ ] T018 Registrar resultados e ordem de merge final no checklist operacional

---

## Dependencies & Execution Order

1. T001-T005
2. T006-T008
3. T009-T012
4. T013-T015
5. T016-T018
