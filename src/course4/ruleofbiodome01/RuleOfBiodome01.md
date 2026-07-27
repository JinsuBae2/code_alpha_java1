# [보고서] SOLID 원칙 분석 및 도서관 시스템 리팩토링 보고서

**작성자:** 배진수  
**작성일:** 2026년 7월 30일  
**대상 코드:** `RuleOfBiodome01_before.java` (package `course4`)

---

## 목차
1. [SOLID 원칙의 등장과 필요성](#1-solid-원칙의-등장과-필요성)
   - 1.1 객체 지향 프로그래밍의 지향점
   - 1.2 SOLID 원칙의 배경 및 필요성
2. [다섯 가지 원칙 소개](#2-다섯-가지-원칙-소개)
   - 2.1 SRP (Single Responsibility Principle, 단일 책임 원칙)
   - 2.2 OCP (Open/Closed Principle, 개방-폐쇄 원칙)
   - 2.3 LSP (Liskov Substitution Principle, 리스코프 치환 원칙)
   - 2.4 ISP (Interface Segregation Principle, 인터페이스 분리 원칙)
   - 2.5 DIP (Dependency Inversion Principle, 의존역전 원칙)
3. [도서관 시스템(RuleOfBiodome01_before.java)에서 SOLID 원칙에 어긋나는 부분](#3-도서관-시스템ruleofbiodome01_beforejava에서-solid-원칙에-어긋나는-부분)
   - 3.1 [LSP 위반] 자식 클래스(Member)가 부모 클래스(User)의 계약을 이행하지 못함
   - 3.2 [ISP 위반] 상위 클래스(User)에 비대한 메서드가 캡슐화되어 불필요한 의존성 강제
   - 3.3 [SRP 위반] 하나의 클래스(Library, User)가 여러 가지 서로 다른 책임을 가짐
   - 3.4 [OCP 위반] 사용자 타입 확장 시 기존 코드(Library) 수정이 불가피함
   - 3.5 [DIP 위반] 고수준/저수준 객체가 구체 클래스에 직접 의존함
4. [보너스 과제: 과정2 프로그램(RoadToBiodome07.java 등)의 SOLID 원칙 위반 분석](#4-보너스-과제-과정2-프로그램roadtobiodome07java-등의-solid-원칙-위반-분석)
   - 4.1 `RoadToBiodome07.java` 코드 구조 분석
   - 4.2 발견된 SOLID 원칙 위반 사항 (SRP, OCP, DIP)
5. [종합 결론 및 개선 방향](#5-종합-결론-및-개선-방향)

---

## 1. SOLID 원칙의 등장과 필요성

### 1.1 객체 지향 프로그래밍의 지향점
객체 지향 프로그래밍(OOP, Object-Oriented Programming)은 단순한 코드의 집합이 아니라, 현실 세계의 개념을 객체(Object)라는 단위로 추상화하여 상호작용하게 함으로써 소프트웨어의 **가독성, 재사용성, 확장성, 유지보수성**을 높이기 위한 패러다임입니다.

### 1.2 SOLID 원칙의 배경 및 필요성
소프트웨어는 끊임없이 요구사항이 변경되고 확장됩니다. 나쁜 설계로 작성된 코드베이스는 작은 수정 하나가 시스템 전체로 사이드 이펙트(Side-effect)를 전파시켜 이른바 **스파게티 코드(Spaghetti Code)** 나 **강한 결합도(Tight Coupling)** 문제를 야기합니다.

로버트 C. 마틴(Robert C. Martin, Uncle Bob)이 제안한 **SOLID 원칙**은 이러한 악순환을 방지하기 위한 5가지 핵심 설계 원칙입니다.
- **유지보수성 향상:** 특정 기능 수정 시 영향을 받는 코드를 최소화합니다.
- **유연한 확장성:** 기존 코드를 건드리지 않고 새로운 기능을 손쉽게 추가할 수 있습니다.
- **결합도 감소 및 응집도 증가:** 클래스 간의 관계를 명확히 하고 각 클래스가 자신의 역할에만 집중하게 합니다.
- **테스트 용이성:** 각 모듈을 독립적으로 단위 테스트(Unit Test)할 수 있는 구조를 제공합니다.

---

## 2. 다섯 가지 원칙 소개

### 2.1 SRP (Single Responsibility Principle, 단일 책임 원칙)
> *"한 클래스는 단 하나의 변경 이유(Reason to change)만을 가져야 한다."*

- **개념:** 하나의 클래스는 오직 하나의 기능/책임만 담당해야 합니다.
- **의의:** 클래스가 여러 책임(데이터베이스 접근, 비즈니스 로직, UI 출력 등)을 동시에 지니면, 한 책임의 변경이 다른 책임에 예기치 않은 부작용을 유발합니다. SRP를 준수하면 모듈의 응집도가 높아집니다.

### 2.2 OCP (Open/Closed Principle, 개방-폐쇄 원칙)
> *"소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에는 열려(Open) 있어야 하고, 수정에는 닫혀(Closed) 있어야 한다."*

- **개념:** 기존 소스 코드를 수정하지 않으면서 새로운 동작이나 기능을 추가할 수 있어야 합니다.
- **의의:** 인터페이스와 다형성(Polymorphism)을 활용하여 구체적인 구현을 추상화함으로써, 신규 기능 요구사항이 들어와도 기존 코드를 안전하게 보호할 수 있습니다.

### 2.3 LSP (Liskov Substitution Principle, 리스코프 치환 원칙)
> *"서브 타입(Subtype)은 언제나 자신의 베이스 타입(Base type)으로 교체할 수 있어야 한다."*

- **개념:** 자식 클래스는 부모 클래스의 규약(계약, Precondition & Postcondition)을 위반하지 않고 완전히 대체할 수 있어야 합니다.
- **의의:** 다형성을 활용할 때 자식 클래스가 부모 클래스의 행동 의도를 깨뜨리면(예: 부모 메서드에서 예외를 던지거나 아무 동작도 하지 않는 경우), 부모 타입을 사용하는 클라이언트 코드가 정상 작동하지 않습니다.

### 2.4 ISP (Interface Segregation Principle, 인터페이스 분리 원칙)
> *"클라이언트는 자신이 사용하지 않는 메서드에 의존하도록 강제되면 안 된다."*

- **개념:** 하나의 비대한(Fat) 범용 인터페이스보다 목적에 맞게 세분화된 여러 개의 인터페이스가 낫습니다.
- **의의:** 자식 클래스나 구현체가 자신에게 필요 없는 메서드를 의무적으로 구현해야 하는 불상사를 막고, 인터페이스 변경 시 불필요한 영향을 차단합니다.

### 2.5 DIP (Dependency Inversion Principle, 의존역전 원칙)
> *"고수준 모듈은 저수준 모듈에 의존해서는 안 되며, 둘 다 추상화에 의존해야 한다."*

- **개념:** 구체적인 클래스(Concrete Class)에 직접 의존하지 않고, 추상화된 인터페이스나 추상 클래스에 의존해야 합니다.
- **의의:** 하위 구체 구현체(예: 특정 DB 기술, 특정 알림 방식)가 변경되더라도 상위 비즈니스 로직은 영향을 받지 않는 유연한 구조를 형성합니다.

---

## 3. 도서관 시스템(RuleOfBiodome01_before.java)에서 SOLID 원칙에 어긋나는 부분

제공된 `RuleOfBiodome01_before.java` 코드를 분석한 결과, 아래와 같이 SOLID 원칙을 명백히 위반하는 지점들이 발견되었습니다.

### 3.1 [LSP 위반] 자식 클래스(Member)가 부모 클래스(User)의 계약을 이행하지 못함

#### 🔴 위반 코드
```java
abstract class User {
    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);
}

class Member extends User {
    public Member(String userId, String name) {
        super(userId, name);
    }
		
    public void addBook(Book book, Library library) {
        System.out.println("Member can't add book");
    }
    public void removeBook(Book book, Library library) {
        System.out.println("Member can't remove book");
    }
}
```

#### 💡 위반 이유 분석
- **부모 클래스(`User`)의 계약 위반:** 부모 클래스 `User`는 `addBook`과 `removeBook`이라는 도서 추가/삭제 메서드를 추상 메서드로 정의하여, 모든 `User` 하위 타입이 도서 관리 기능을 수행할 것임을 계약(Contract)으로 선언했습니다.
- **리스코프 치환 불가:** 그러나 자식 클래스인 `Member`는 일반 대출 회원으로서 도서를 추가하거나 삭제할 권한이 없습니다. 이에 따라 메서드를 오버라이드하였으나 실질적인 기능 수행 대신 경고 문구("Member can't add book")만 출력합니다.
- 만약 다형성을 이용하여 `List<User>` 목록에 들어있는 사용자 객체들을 순회하며 `user.addBook(...)`을 호출할 경우, `Member` 객체는 올바른 동작을 하지 못하므로 **자식 객체가 부모 객체를 완전하게 대체할 수 없게 되어 LSP를 명백하게 위반**합니다.

---

### 3.2 [ISP 위반] 상위 클래스(User)에 비대한 메서드가 캡슐화되어 불필요한 의존성 강제

#### 🔴 위반 코드
```java
abstract class User {
    public String userId;
    public String name;

    public void borrowBook(Book book) { ... }
    public void returnBook(Book book) { ... }

    // 관리자 전용 기능이 일반 사용자 추상 클래스에 강제로 포함됨
    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library); 
}
```

#### 💡 위반 이유 분석
- **불필요한 메서드 강제 구현:** `User` 클래스는 대출/반납 기능(`borrowBook`, `returnBook`)과 도서 관리 기능(`addBook`, `removeBook`)이라는 완전히 서로 다른 성격의 역할들을 하나의 인터페이스/추상 클래스 안에 묶어 두었습니다.
- 그 결과, 도서 관리 기능이 필요 없는 일반 회원인 `Member` 클래스조차 `addBook`과 `removeBook` 메서드를 강제로 구현해야만 하는 비효율이 발생하였습니다. 이는 **자신이 사용하지 않는 메서드에 의존하도록 강제해서는 안 된다는 ISP 원칙을 위반**한 전형적인 예시입니다.

---

### 3.3 [SRP 위반] 하나의 클래스(Library, User)가 여러 가지 서로 다른 책임을 가짐

#### 🔴 위반 코드
```java
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    // 책임 1: 도서 객체 생성 (팩토리 역할) + 책 목록 관리
    public Book writeBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        books.add(book);
        return book;
    }
    public void addBook(Book book) { books.add(book); }
    public void removeBook(Book book) { books.remove(book); }

    // 책임 2: 회원 및 관리자 명단 관리
    public void addMember(Member member) { users.add(member); }
    public void addManager(Manager manager) { users.add(manager); }
}
```

#### 💡 위반 이유 분석
- **다중 책임 보유:** `Library` 클래스는 단순한 도서관 장서 관리뿐만 아니라, ① `writeBook()` 메서드를 통한 도서 생성(Factory 책임), ② `books` 리스트 관리(도서 인벤토리 책임), ③ `users` 리스트 관리(사용자/회원 관리 책임)를 동시에 수행하고 있습니다.
- 도서 생성 규칙이 바뀔 때, 도서 저장 방식이 바뀔 때, 사용자 등록 로직이 바뀔 때 모두 `Library` 클래스를 수정해야 하므로 **클래스가 변경되어야 하는 이유가 3가지 이상** 존재합니다. 이는 단일 책임 원칙(SRP)에 어긋납니다.

---

### 3.4 [OCP 위반] 사용자 타입 확장 시 기존 코드(Library) 수정이 불가피함

#### 🔴 위반 코드
```java
class Library {
    // ...
    public void addMember(Member member) {
        users.add(member);
    }

    public void addManager(Manager manager) {
        users.add(manager);
    }
}
```

#### 💡 위반 이유 분석
- **구체 타입에 결합된 메서드 오버로딩:** `Library` 클래스는 사용자 등록 시 다형적 추상 타입인 `User`를 활용하지 않고, 구체 클래스인 `Member`와 `Manager`를 각각 매개변수로 받는 `addMember()`와 `addManager()` 메서드를 따로 두고 있습니다.
- 만약 추후 시스템에 `Staff`(직원), `Guest`(방문객), `VIPMember`(우수회원) 등 새로운 사용자 유형이 추가된다면, 기존 `Library` 클래스의 소스 코드를 직접 수정하여 `addStaff()`, `addGuest()` 등의 새로운 메서드를 계속 추가해야 합니다.
- **확장에는 열려있고 수정에는 닫혀있어야 한다는 OCP 원칙을 위반**하고 있습니다.

---

### 3.5 [DIP 위반] 고수준/저수준 객체가 구체 클래스에 직접 의존함

#### 🔴 위반 코드
```java
class Member extends User {
    // ...
    public void addBook(Book book, Library library) { ... }
}

class Manager extends User {
    // ...
    public void addBook(Book book, Library library) {
        library.addBook(book); // 구체 클래스 Library에 직접 의존
    }
}
```

#### 💡 위반 이유 분석
- **구체 클래스 간의 강한 결합:** `User` 및 그 하위 클래스인 `Manager`가 추상화된 도서 저장소/도서관 인터페이스(예: `BookManageable` 또는 `BookRepository`)가 아닌, 구체 클래스인 `Library` 객체를 매개변수로 받아 직접 메서드를 호출하고 있습니다.
- 데이터베이스나 도서관 저장소 구현체(예: `DigitalLibrary`, `OfflineLibrary`)가 변경되거나 교체될 때 `User`와 `Manager` 클래스까지 함께 영향을 받으므로 **DIP(의존역전 원칙)를 위반**합니다.

---

## 4. 보너스 과제: 과정2 프로그램(RoadToBiodome07.java 등)의 SOLID 원칙 위반 분석

과정2에서 구현했던 대표적인 프로그램인 `RoadToBiodome07.java`의 코드를 검토하여 SOLID 원칙 관점에서 분석하였습니다.

### 4.1 `RoadToBiodome07.java` 코드 구조 요약
`RoadToBiodome07.java`는 단일 클래스(`RoadToBiodome07`) 내부에 `main` 메서드를 비롯하여 문자열 파싱/검증, 빈도수 계산, 정렬 알고리즘(선택 정렬, 병합 정렬), 배열 출력 메서드가 `static` 메서드로 모두 몰려있는 형태입니다.

```java
public class RoadToBiodome07 {
    public static void main(String[] args) { ... }
    private static void printArray(String[] arr, int count) { ... }
    private static void selectionSort(int[] frequencies, int uniqueCount, String[] uniqueAnimals) { ... }
    private static void mergeSort(int[] frequencies, String[] uniqueAnimals, int left, int right) { ... }
    private static void merge(...) { ... }
    private static int calculateFrequency(...) { ... }
}
```

### 4.2 발견된 SOLID 원칙 위반 사항

1. **SRP (단일 책임 원칙) 위반:**
   - `RoadToBiodome07` 클래스 하나가 **입력 데이터 검증 및 파싱**, **동물 등장 빈도 분석**, **정렬 알고리즘 실행**, **콘솔 출력 UI 제어**라는 4가지 전혀 다른 책임을 동시에 지니고 있습니다.
   - 출력 포맷이 바뀌거나, 입력 데이터 형식(JSON/CSV 등)이 바뀌거나, 정렬 알고리즘 로직이 바뀔 때 모두 이 한 클래스를 수정해야 합니다.

2. **OCP (개방-폐쇄 원칙) 위반:**
   - 정렬 방식을 변경하거나 새로운 정렬 알고리즘(예: 퀵 정렬, 힙 정렬)을 도입하려면 `RoadToBiodome07` 클래스 내부에 새로운 `static` 메서드를 추가하고 `main` 메서드의 하드코딩된 호출 로직을 직접 수정해야 합니다.
   - `SortStrategy` 인터페이스를 정의하고 정렬 알고리즘을 전략 패턴(Strategy Pattern)으로 분리하지 않아 **확장에 닫혀있고 수정에 열려있는 문제**가 발생합니다.

3. **DIP (의존역전 원칙) 위반:**
   - `main` 메서드가 추상화된 정렬 인터페이스가 아닌, 클래스 내부의 구체적인 `selectionSort` 및 `mergeSort` `static` 메서드에 직접 의존하고 있어 결합도가 극도로 높습니다.

---

## 5. 종합 결론 및 개선 방향

이번 보고서를 통해 SOLID 원칙이 왜 객체 지향 프로그래밍에서 핵심적인 가치를 가지는지 확인할 수 있었습니다.

- `RuleOfBiodome01_before.java` 도서관 시스템의 경우:
  1. **사용자 역할과 행위의 분리:** `User` 클래스에서 관리자 기능(`addBook`, `removeBook`)을 제거하고, 관리용 인터페이스(`BookManageable`) 또는 별도의 `Admin` 객체로 분리하여 **LSP, ISP**를 준수해야 합니다.
  2. **Library 역할 분리:** 도서 생성(Factory), 회원 관리(UserManager), 장서 관리(BookRepository)로 클래스를 분할하여 **SRP**를 준수해야 합니다.
  3. **다형성 활용 및 추상화 의존:** `Library.addUser(User user)`처럼 다형적 인터페이스에 의존하도록 개편하여 **OCP, DIP**를 만족시켜야 합니다.

SOLID 원칙을 준수하는 리팩토링을 진행하면 요구사항 변경에도 흔들리지 않는 견고하고 유연한 자바 애플리케이션을 구축할 수 있습니다.
