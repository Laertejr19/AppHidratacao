# 💧 App Hidratacao Diaria

Aplicativo Android desenvolvido em **Java + XML** no **Android Studio**, para auxiliar no controle da ingestão diária de água, com base no peso corporal do usuário.  
Projeto criado como parte dos estudos de **desenvolvimento mobile nativo** e para praticar lógica de cálculo aplicada à saúde.

---

## 🧠 Sobre o Projeto

O **App Hidratacao Diaria** permite ao usuário calcular a quantidade ideal de água a ser consumida diariamente com base em seu peso corporal.  
O aplicativo fornece o valor estimado em mililitros (ml) e exibe uma barra de progresso indicando o quanto já foi consumido e quanto falta para atingir a meta.

---

## 🛠️ Tecnologias Utilizadas

| Categoria         | Ferramenta                         |
|-------------------|------------------------------------|
| IDE               | Android Studio                     |
| Linguagem         | Java                               |
| Layouts           | XML                                |
| Versão mínima Android | API 21 (Android 5.0)             |
| Estrutura de UI   | ConstraintLayout / LinearLayout    |

---

## 📱 Estrutura do Projeto

```
app/
 ├── java/
 │    └── br/ulbra/apphidratacao/
 │         └── MainActivity.java
 ├── res/
 │    ├── layout/
 │    │     └── activity_main.xml
 │    ├── drawable/
 │    │     └── (ícones ou imagens do app)
 │    └── values/
 │          └── strings.xml
 └── AndroidManifest.xml
```

---

## ⚙️ Lógica de Cálculo de Ingestão de Água

```java
double peso = Double.parseDouble(editPeso.getText().toString());
double aguaIdeal = peso * 35; // 35 ml por kg de peso corporal

textAguaIdeal.setText("Meta diária: " + aguaIdeal + " ml");
```

**Exemplo com barra de progresso:**

```java
ProgressBar progressBar = findViewById(R.id.progressBar);
progressBar.setMax((int) aguaIdeal);
progressBar.setProgress(consumoAtual);
```

---

## 🏗️ Funcionalidades Implementadas

✅ Cálculo da quantidade ideal de água diária  
✅ Exibição de barra de progresso do consumo  
✅ Interface simples e funcional  
✅ Código comentado para entendimento  

---

## 💡 Possíveis Melhorias

- Adicionar histórico de consumo com SQLite  
- Enviar notificações para lembrar o usuário de beber água  
- Tema claro/escuro  
- Exportar relatório em PDF/CSV  
- Adicionar animações e ícones personalizados  

---

## 👩‍💻 Autor

**Nome:** *Laerte Ferraz da Silva Júnior*  
**Instituição:** *Curso Técnico em Informática – Escola Ulbra São Lucas*  
**Disciplina:** *Desenvolvimento Mobile Android*  
**Professor:** *Jeferson Leon*  

---

## 📚 Licença

Projeto desenvolvido para fins **educacionais**.  
Livre para uso e modificação, desde que mantidos os créditos ao autor.

---

> “A melhor forma de aprender é construindo. Então... bora codar!”
