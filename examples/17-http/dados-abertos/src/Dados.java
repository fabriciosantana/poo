import java.util.List;

record ListaParlamentarEmExercicio(Parlamentares Parlamentares) {}
record Parlamentares(List<Parlamentar> Parlamentar) {}
record Parlamentar(IdentificacaoParlamentar IdentificacaoParlamentar, Mandato Mandato) {}
record IdentificacaoParlamentar(String NomeParlamentar, String SiglaPartidoParlamentar, String UfParlamentar) {}
record Mandato(String CodigoMandato,
               String UfParlamentar,
               Legislatura PrimeiraLegislaturaDoMandato,
               Legislatura SegundaLegislaturaDoMandato,
               String DescricaoParticipacao,
               Suplentes Suplentes,
               Exercicios Exercicios) {}
record Legislatura(String NumeroLegislatura, String DataInicio, String DataFim) {}
record Suplentes(List<Suplente> Suplente) {}
record Suplente(String DescricaoParticipacao, String CodigoParlamentar, String NomeParlamentar) {}
record Exercicios(List<Exercicio> Exercicio) {}
record Exercicio(String CodigoExercicio, String DataInicio, String DataFim) {}
