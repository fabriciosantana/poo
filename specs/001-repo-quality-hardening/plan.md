# Implementation Plan: Repository Quality Hardening

**Branch**: `001-repo-quality-hardening` | **Date**: 2026-03-06 | **Spec**: [/workspaces/poo/specs/001-repo-quality-hardening/spec.md](/workspaces/poo/specs/001-repo-quality-hardening/spec.md)
**Input**: Feature specification from `/specs/001-repo-quality-hardening/spec.md`

## Summary

Executar um pacote de melhorias de segurança, operação e clareza didática em 6 PRs pequenos,
com ordem de merge definida. O foco é eliminar risco de segredos expostos, restaurar automações
para o semestre 2026.1 e reduzir ruído para alunos com documentação consistente.

## Technical Context

**Language/Version**: Java 21, Bash, YAML, Markdown  
**Primary Dependencies**: JUnit Platform Console, GitHub Actions, Maven (somente onde houver `pom.xml`)  
**Storage**: Arquivos no repositório (N/A para banco persistente nesta feature)  
**Testing**: validação por `bash -n`, revisão de paths e inspeção estática por `rg`  
**Target Platform**: Linux (Codespaces/GitHub Actions)  
**Project Type**: repositório educacional monolítico  
**Performance Goals**: feedback de workflow legível em uma execução padrão de CI  
**Constraints**: manter compatibilidade com estrutura atual de `assignments/` e sem quebrar material de aula  
**Scale/Scope**: atualização de docs + workflows + scripts + exemplos JDBC/JPA prioritários

## Constitution Check

*GATE: Must pass before implementation starts. Re-check after each PR.*

1. Pedagogy-First Artifacts: mudanças de texto preservam objetivo didático.
2. Secure-by-Default Teaching Examples: remover credenciais e endpoints reais.
3. Testable Assignments and Fast Feedback: workflows/scripts consistentes com paths reais.
4. Stable Structure and Naming: corrigir paths de submissão e links quebrados.
5. Semester-Ready Operations: branch ativa `2026.1` nos workflows de submissão.

Resultado inicial: **PASS with action items** (itens já endereçados na lista de tarefas).

## Project Structure

### Documentation (this feature)

```text
specs/001-repo-quality-hardening/
├── spec.md
├── plan.md
└── tasks.md
```

### Source Code (repository root)

```text
.github/workflows/
scripts/
assignments/
examples/
README.md
docs/
```

**Structure Decision**: atuar diretamente nos artefatos já existentes, sem criar novo módulo.

## Complexity Tracking

| Violation | Why Needed | Simpler Alternative Rejected Because |
|-----------|------------|--------------------------------------|
| Nenhuma | N/A | N/A |
