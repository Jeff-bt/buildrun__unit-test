# 🧪 Testes Unitários com JUnit 5 e Mockito

Este repositório contém exemplos práticos de testes unitários em Java, utilizando **JUnit 5** e **Mockito**. O objetivo
é demonstrar como aplicar boas práticas de testes, incluindo o uso de *Test Doubles* como **Dummy**, **Stub**, **Mock**
e **Spy**.

---

## 📚 O que são Testes Unitários?

Testes unitários verificam o comportamento de unidades isoladas do código, como métodos ou funções. Eles são essenciais
para:

- ✅ Garantir que cada parte do código funcione corretamente de forma independente.
- 🔁 Facilitar a manutenção e refatoração do código.
- 📝 Servir como documentação viva do comportamento esperado.

---

## ⚙️ JUnit 5

O **JUnit 5** introduziu diversas melhorias em relação às versões anteriores, incluindo suporte ao **Java 8+**, uma
arquitetura modularizada e maior extensibilidade. Ele é composto por três partes principais:

- **JUnit Platform**: Infraestrutura que permite a execução de testes em diferentes engines.
- **JUnit Jupiter**:  API que traz suporte a novas anotações e funcionalidades modernas para testes no JUnit 5.
- **JUnit Vintage**: Suporte para execução de testes escritos em versões anteriores do JUnit (JUnit 3 e 4).

### 🔄 Ciclo de Vida de um Teste

O JUnit 5 introduz um conjunto de anotações que controlam o ciclo de vida dos testes, garantindo que a configuração e a
limpeza dos recursos ocorram na ordem correta. As principais anotações são:

- **@BeforeAll** → Executa um trecho de código **antes de todos os testes da classe.**
- **@BeforeEach** → Executa um trecho **antes de cada teste individual.**
- **@Test** → Define um **método de teste**, contendo a lógica de verificação (asserts).
- **@AfterEach** → Executa um trecho **após cada teste.**
- **@AfterAll** → Executa um trecho **após todos os testes da classe.**

Esse ciclo de vida permite configurar um ambiente adequado antes da execução dos testes e limpar recursos após sua
finalização.

### ✅ Exemplo com JUnit 5

```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Antes de tudo!");
	}

	@Test
	void testSoma() {
		int resultado = 2 + 3;
		assertEquals(5, resultado, "A soma deve ser 5");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("Depois de tudo!");
	}
}
```

---

## 🧰 Mockito

O **Mockito** é uma biblioteca que facilita a criação de objetos simulados (*mocks*) para testes. Ele permite:

- 🧪 Simular comportamentos de dependências externas.
- 👁️ Verificar interações entre objetos.
- 🧱 Criar *Test Doubles* como **Mock** e **Spy**.

### 🧵 Integração com JUnit 5

```java
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MeuTeste {
	// ...
}
```

---

## 🎭 Tipos de Test Doubles

### 🔄 O que são Test Doubles?

Os **Test Doubles** (ou dublês de teste) são **objetos substitutos** usados para isolar partes do código durante a
execução dos
testes. Eles ajudam a testar funcionalidades sem depender de implementações externas, como bancos de dados ou APIs.

Os principais tipos de **Test Doubles** são:

- **Dummy Object** → Apenas preenche parâmetros obrigatórios, sem lógica.
- **Test Stub** → Retorna valores pré-definidos quando métodos são chamados.
- **Mock Object** → Simula interações e permite verificar chamadas de métodos.
- **Test Spy** → Mantém o comportamento real dos métodos, mas permite monitorar interações.
- **Fake Object** → Implementação alternativa que simula um sistema real.

### 🔹 Dummy

Usado apenas para preencher argumentos, mas não participa da lógica do teste.

```java

class DummyUser implements User {
	// Implementação mínima necessária para compilar
}

@Test
void testWithDummy() {
	User dummyUser = new DummyUser();
	Service service = new Service(dummyUser);
	// ...
}
```

---

### 🔹 Stub

Retorna dados controlados para cenários de teste.

```java

@Test
void testWithStub() {
	Database dbStub = mock(Database.class);
	when(dbStub.getStatus(1)).thenReturn("ACTIVE"); //Isso é o Test stub, quando receber 1 no status, ele retornará "ACTIVE"

	UserService service = new UserService(dbStub);
	assertEquals("ACTIVE", service.getUserStatus(1));
}
```

---

### 🔹 Mock

Permite verificar se métodos foram chamados corretamente.

```java

@Test
void testWithMock() {
	List<String> mockedList = mock(List.class);

	mockedList.add("item");

	verify(mockedList).add("item");  // Verifica se o método foi chamado
}
```

---

### 🔹 Spy

Permite monitorar chamadas reais de métodos e também sobrescrever comportamentos.

```java

@Test
void testWithSpy() {
	List<String> spyList = spy(new ArrayList<>());

	spyList.add("item");
	assertEquals(1, spyList.size());  // Mantém o comportamento real

	verify(spyList).add("item");  // Verifica a chamada do método
}
```




