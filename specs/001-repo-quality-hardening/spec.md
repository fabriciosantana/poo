# Feature Specification: Repository Quality Hardening

**Feature Branch**: `001-repo-quality-hardening`  
**Created**: 2026-03-06  
**Status**: Draft  
**Input**: User description: "Transformar melhorias do repositório em 6 PRs operacionais, implementar mudanças com Speckit e propor constitution."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Segurança dos Exemplos (Priority: P1)

Como professor, quero remover credenciais reais e padronizar placeholders em exemplos JDBC/JPA,
para não expor dados sensíveis e ensinar prática segura.

**Why this priority**: Exposição de segredo é risco imediato e deve bloquear novas entregas.

**Independent Test**: Buscar padrões de segredo no código e verificar que apenas placeholders
permanecem.

**Acceptance Scenarios**:

1. **Given** arquivos de exemplo com URL/usuário/senha reais, **When** a mudança é aplicada,
**Then** os exemplos usam placeholders e comentários de segurança.
2. **Given** revisão de código no diretório de exemplos, **When** grep por credenciais é
executado, **Then** não há senha real versionada.

---

### User Story 2 - Automação confiável de avaliação (Priority: P1)

Como professor, quero workflows e scripts alinhados à estrutura atual do repositório, para que
testes automáticos funcionem no semestre vigente.

**Why this priority**: Falha em CI/scripts impacta correção de atividades e operação da turma.

**Independent Test**: Rodar validação de sintaxe e inspeção dos caminhos/branches referenciados.

**Acceptance Scenarios**:

1. **Given** workflows com branch/caminhos legados, **When** atualizados, **Then** passam a
referenciar `2026.1` e diretórios existentes.
2. **Given** scripts locais de teste/limpeza, **When** executados em modo seguro, **Then** não
apontam para diretórios inexistentes.

---

### User Story 3 - Clareza do conteúdo e navegação (Priority: P2)

Como aluno, quero README e enunciados consistentes, sem links quebrados e com nomenclatura
padronizada, para reduzir dúvidas operacionais.

**Why this priority**: Melhora experiência do aluno e reduz suporte repetitivo.

**Independent Test**: Verificar links locais, typos críticos e caminhos de submissão.

**Acceptance Scenarios**:

1. **Given** README com links para caminhos inexistentes, **When** corrigido, **Then** links
locais resolvem para diretórios válidos.
2. **Given** enunciados com paths incorretos, **When** revisados, **Then** o caminho de entrega
segue padrão `submissions/<nome-sobrenome>/src`.

### Edge Cases

- Atividades sem pasta `test/` não devem quebrar workflow de submissões.
- Scripts de limpeza devem tolerar ausência de diretórios opcionais.
- Ajustes textuais não devem alterar conteúdo pedagógico obrigatório.

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: O repositório MUST remover credenciais hardcoded dos arquivos identificados no escopo.
- **FR-002**: Workflows MUST apontar para branch ativa e caminhos existentes.
- **FR-003**: Scripts de suporte MUST usar paths atuais e falhar com mensagens acionáveis.
- **FR-004**: README raiz MUST corrigir links locais quebrados e erros ortográficos críticos.
- **FR-005**: Readmes de assignments MUST usar caminhos corretos de submissão.
- **FR-006**: O projeto MUST registrar plano de execução em 6 PRs com ordem de merge.

### Key Entities *(include if feature involves data)*

- **PR Operacional**: unidade de entrega com objetivo, arquivos-alvo e critério de aceite.
- **Artefato Speckit**: `spec.md`, `plan.md` e `tasks.md` usados para rastreabilidade de execução.
- **Governança do Curso**: regras constitucionais sobre segurança, avaliação e manutenção semestral.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: 100% dos arquivos do escopo P1 deixam de conter credenciais reais.
- **SC-002**: 100% dos workflows modificados referenciam branch/caminhos válidos no repositório.
- **SC-003**: 100% dos links locais ajustados no README principal resolvem para paths existentes.
- **SC-004**: Existe um checklist operacional PR-01..PR-06 com ordem de merge e critérios de aceite.
