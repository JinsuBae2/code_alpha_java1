# Context Loading Policy

필요한 문서만 읽어 정확성과 토큰 효율을 함께 유지한다. 작업에 맞는 문서를 모두
기억하려 하지 말고, 아래 최소 집합부터 시작해 부족할 때만 하나씩 추가한다.

## Do Not Load

다음 작업은 저장소 정보가 필요하지 않으면 `.ai` 문서를 읽지 않는다.

- 일반 질문, 개념 설명, 번역, 문장 작성, 아이디어 제안
- 사용자가 제공한 짧은 코드 조각의 문법 설명
- 현재 저장소와 무관한 예제 작성

## Minimum Context by Task

| 작업 | 먼저 읽을 문서 | 필요할 때만 추가 |
|---|---|---|
| 저장소 탐색·작은 코드 수정 | `AGENTS.md` | `CODING_RULES.md` |
| Java/Spring 백엔드 수정 | `AGENTS.md`, `BACKEND_RULES.md` | `API_RULES.md`, `CHECKLIST.md` |
| HTTP API 추가·변경 | `AGENTS.md`, `API_RULES.md` | `BACKEND_RULES.md`, `CHECKLIST.md` |
| 코드 리뷰 | `REVIEW.md` | `API_RULES.md`, `BACKEND_RULES.md` |
| 학습·멘토링 | `LEARNING.md` | 없음 |
| 기술·보안·데이터·공개 계약 결정 | `DECISION.md` | `API_RULES.md`, `PROJECT_RULES.md` |
| 프로젝트 명령·구조·제약 확인 | `PROJECT_RULES.md` | 실제 코드·설정·CI |

## Escalation Rules

- `CHECKLIST.md`는 변경을 마무리하거나 위험이 높을 때만 읽는다.
- `AI_PHILOSOPHY.md`, `VIBE_CODING.md`는 작업 방식이 흔들리거나 새 협업 방식을
  설계할 때만 읽는다.
- `DEVELOPER.md`, `MEMORY.md`는 사용자 선호나 장기 기억을 기록·수정할 때만 읽는다.
- 같은 작업에서 이미 읽은 문서는 다시 읽지 않는다. 파일이 변경되었거나 불확실할 때만
  다시 확인한다.
- 문서에 없는 프로젝트 사실은 `PROJECT_RULES.md`의 템플릿으로 추측하지 말고 실제
  코드·설정·문서에서 확인한다.
