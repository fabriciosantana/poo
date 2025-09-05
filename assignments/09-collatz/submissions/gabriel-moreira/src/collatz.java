class CollatzSequence:
    """
    Representa uma sequência de Collatz e suas operações.
    """
    @staticmethod
    def proximo_termo(n: int) -> int:
        """
        Calcula o próximo termo da sequência de Collatz.

        Se o número for par, retorna n / 2.
        Se o número for ímpar, retorna (n * 3) + 1.
        """
        if n % 2 == 0:
            return n 
        return (n * 3) + 1

    @staticmethod
    def gerar_e_somar(semente: int) -> tuple[list[int], int]:
        """
        Gera a sequência de Collatz a partir da semente e calcula a soma.

        Retorna a sequência completa e a soma de seus termos.
        """
        if semente <= 0:
            return [], 0

        sequencia = []
        termo_atual = semente
        while termo_atual != 1:
            sequencia.append(termo_atual)
            termo_atual = CollatzSequence.proximo_termo(termo_atual)
        sequencia.append(1)  # Adiciona o 1 ao final da sequência

        soma_total = sum(sequencia)
        return sequencia, soma_total

def main():
    """
    Função principal do programa.
    
    Solicita a semente, valida a entrada e exibe a sequência e a soma.
    """
    try:
        # Pede um número e já converte para inteiro
        semente_str = input("Digite um número inteiro positivo para a sequência de Collatz: ")
        semente = int(semente_str)

        # Trata o caso de números menores que 1
        if semente <= 0:
            print("Erro: O número deve ser um inteiro positivo.")
            return

        # Gera a sequência e a soma em uma única chamada
        sequencia, soma = CollatzSequence.gerar_e_somar(semente)

        # Exibe os resultados de forma clara e direta
        sequencia_formatada = " → ".join(map(str, sequencia))
        print(f"Sequência: {sequencia_formatada}")
        print(f"Soma dos termos: {soma}")

    except ValueError:
        print("Erro: A entrada precisa ser um número inteiro. Tente novamente.")


if __name__ == "__main__":
    main()