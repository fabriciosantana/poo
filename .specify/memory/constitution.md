<!--
Sync Impact Report
- Version change: 0.0.0 -> 1.0.0
- Modified principles: template placeholders -> 5 concrete principles
- Added sections: Additional Constraints, Development Workflow
- Removed sections: none
- Templates requiring updates:
  - ✅ .specify/templates/plan-template.md (already compatible via Constitution Check section)
  - ✅ .specify/templates/spec-template.md (already compatible with measurable requirements)
  - ✅ .specify/templates/tasks-template.md (already compatible with traceable tasks)
- Follow-up TODOs: none
-->
# POO Repository Constitution

## Core Principles

### I. Pedagogy-First Artifacts
Every student-facing artifact MUST optimize clarity before cleverness. Enunciados, examples,
and README content MUST provide objective, expected output/behavior, and reproducible steps.
Ambiguous instructions and missing acceptance criteria are not allowed.

### II. Secure-by-Default Teaching Examples
No real credentials, tokens, secrets, or private endpoints may be committed. Database URLs,
users, and passwords in examples MUST use placeholders or local sample values. Any accidental
secret exposure MUST be remediated in the next PR before new content is added.

### III. Testable Assignments and Fast Feedback
Programming assignments SHOULD include executable tests whenever feasible. If a task has no
automated tests, the README MUST include explicit manual verification criteria. Scripts and CI
must prioritize deterministic feedback for students and instructors.

### IV. Stable Structure and Naming
Directory names, submission paths, and class naming conventions MUST remain consistent across
semesters. Legacy aliases may exist temporarily, but canonical paths must be documented in the
root README and assignment readmes. Broken local links are treated as defects.

### V. Semester-Ready Operations
Operational assets (workflows, cleanup scripts, test scripts) MUST target the active semester
branch and the current repository layout. Changes that affect grading or submission pipelines
must be validated with a dry run before merge.

## Additional Constraints

1. Default Java baseline is JDK 21 for assignments/examples unless explicitly documented.
2. Student submissions are source of truth and must never be silently rewritten by automation.
3. CI jobs must fail with actionable messages in Portuguese or clear bilingual wording.
4. Public documentation should use concise language and avoid stale semester references.

## Development Workflow

1. Every meaningful repository-wide change SHOULD be described through Speckit artifacts:
`spec.md`, `plan.md`, and `tasks.md`.
2. Implementation tasks must be traceable to a requirement or user story.
3. Multi-file refactors should be split into small PRs with explicit merge order.
4. Before merge, verify:
   - links and paths are valid;
   - workflows reference existing directories;
   - no secrets were introduced.

## Governance

This constitution supersedes informal conventions for this repository.

Amendment policy:
1. Amendments require a dedicated PR with rationale and migration impact.
2. Versioning follows semantic intent:
   - MAJOR: incompatible governance or principle removals/rewrites.
   - MINOR: new principle/section or materially stronger rule.
   - PATCH: wording/clarity updates without semantic change.
3. Compliance checks are mandatory in reviews for docs, assignments, workflows, and scripts.

**Version**: 1.0.0 | **Ratified**: 2026-03-06 | **Last Amended**: 2026-03-06
