---
layout: frontcover
transition: none
title: IDP - POO
id: aula15
lesson: Persistência com JPA
goals:
  - Mapear entidades com anotações JPA
  - Utilizar `EntityManager` para operações CRUD
  - Construir consultas com Criteria API
---

---
layout: default
lesson: Entidades
---

## Classe `Actor`

```java
// model/Actor.java
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
```

- Anotações mapeiam atributos para colunas da tabela `actor`
- `@GeneratedValue` delega geração da chave ao banco
- Construtor sem argumentos obrigatório pela JPA
- Estados de entidade: *new*, *managed*, *detached*, *removed*
- `@Column` pode configurar nulabilidade, tamanho e nome customizado

---

## DAO e `EntityManager`

```java
// ActorDAO.java
public void insert(Actor actor) {
    em.getTransaction().begin();
    em.persist(actor);
    em.getTransaction().commit();
    AuditLogger.log("INSERT", "Ator inserido: " + actor);
}

public List<Actor> findAll() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
    Root<Actor> root = cq.from(Actor.class);
    cq.select(root).orderBy(cb.asc(root.get("actorId")));
    return em.createQuery(cq).getResultList();
}
```

- Transações explícitas em operações mutáveis (`persist`, `merge`, `remove`)
- Criteria API fornece consultas type-safe e dinâmicas
- `EntityManager` mantém um *persistence context* com cache de primeiro nível
- `merge` sincroniza entidades *detached*; `persist` cadastra entidades novas

---

## Fluxo principal

```java
// HeartRatesTest.java (trecho)
EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrentalPU");
EntityManager em = emf.createEntityManager();

ActorDAO dao = new ActorDAO(em);
Actor novo = new Actor("Joao", "Silva");
dao.

insert(novo);

List<Actor> allActors = dao.findAll();
allActors.

forEach(System.out::println);
```

- `persistence.xml` define unidade de persistência e conexão
- Sempre feche `EntityManager` e `EntityManagerFactory`
- Atualização e remoção reutilizam métodos `update` e `delete`
- Use `TypedQuery` para consultas JPQL quando Criteria for excessivamente verbosa
- Evite consultas N+1 configurando *fetch joins* ou relacionamentos com `fetch = FetchType.LAZY`

---

## Projetos de referência

- `dvdrentalapp-maven`: aplicação console com JPA + Criteria API
- `dvdrentalapp-sprintdatajpa`: configuração base para Spring Data JPA
- `README.md` explica requisitos de banco e scripts de inicialização
- Use `docker-compose` de JDBC para levantar o banco rapidamente
- Mapeamentos mais complexos incluem relacionamentos (`@OneToMany`, `@ManyToMany`)
- Validações combinam Bean Validation (`@NotNull`) com regras de banco

---
layout: backcover
---
