
# 🧪 Testes Unitários com JUnit 5 e Mockito

Este repositório contém exemplos práticos de testes unitários em Java, utilizando **JUnit 5** e **Mockito**. O objetivo é demonstrar como aplicar boas práticas de testes, incluindo o uso de *Test Doubles* como **Dummy**, **Stub**, **Mock** e **Spy**.

---

## 📚 O que são Testes Unitários?

Testes unitários verificam o comportamento de unidades isoladas do código, como métodos ou funções. Eles são essenciais para:

- ✅ Garantir que cada parte do código funcione corretamente de forma independente.
- 🔁 Facilitar a manutenção e refatoração do código.
- 📝 Servir como documentação viva do comportamento esperado.

---

## ⚙️ JUnit 5

O **JUnit 5** é a evolução do popular framework de testes para Java. Ele é composto por três subprojetos principais:

- **JUnit Platform**: Plataforma de execução de testes.
- **JUnit Jupiter**: API e modelo de programação para escrever testes.
- **JUnit Vintage**: Suporte para testes escritos com versões anteriores do JUnit.

### ✅ Exemplo com JUnit 5

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void deveSomarDoisNumeros() {
        Calculadora calc = new Calculadora();
        assertEquals(4, calc.somar(2, 2));
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

Durante os testes, usamos objetos substitutos para simular comportamentos. Os principais tipos são:

### 🔹 Dummy

Usado apenas para preencher argumentos, mas não participa da lógica do teste.

```java
@Test
void deveAceitarObjetoDummy() {
    Servico servico = new Servico();
    DummyObjeto dummy = new DummyObjeto();
    assertDoesNotThrow(() -> servico.processar(dummy));
}
```

---

### 🔹 Stub

Retorna dados controlados para cenários de teste.

```java
when(apiStub.getTaxa()).thenReturn(0.15);

double resultado = calculadora.calcularComTaxa(100);
assertEquals(115, resultado);
```

---

### 🔹 Mock

Permite verificar se métodos foram chamados corretamente.

```java
Pedido pedido = new Pedido(mockEmailService);
pedido.confirmar();

verify(mockEmailService).enviarEmailDeConfirmacao(any());
```

---

### 🔹 Spy

Permite monitorar chamadas reais de métodos e também sobrescrever comportamentos.

```java
List<String> lista = spy(new ArrayList<>());
lista.add("item");

verify(lista).add("item");
assertEquals(1, lista.size());
```

---

## 🚀 Como Executar

```bash
git clone https://github.com/Jeff-bt/buildrun__unit-test.git
cd buildrun__unit-test
mvn test
```

---

## 🤝 Contribuições

Contribuições são bem-vindas! Fique à vontade para enviar melhorias ou sugestões abrindo uma *issue* ou *pull request*.

---

## 📢 Compartilhe

Se esse conteúdo te ajudou, compartilhe no LinkedIn e marque outros devs que também estão estudando testes! 🚀
