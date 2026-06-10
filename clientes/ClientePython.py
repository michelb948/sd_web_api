import requests

URL = "http://localhost:8080/api"

while True:

    print("\n=== ESTOQUE ===")
    print("1 - Listar produtos")
    print("2 - Buscar produto")
    print("3 - Comprar produto")
    print("4 - Adicionar produto")
    print("0 - Sair")

    op = input("Opcao: ")

    if op == "1":

        resposta = requests.get(
            f"{URL}/produtos"
        )

        for p in resposta.json():
            print(p)

    elif op == "2":

        id_produto = input("ID: ")

        resposta = requests.get(
            f"{URL}/produtos/{id_produto}"
        )

        print(resposta.json())

    elif op == "3":

        id_produto = int(input("ID: "))
        qtd = int(input("Quantidade: "))

        resposta = requests.post(
            f"{URL}/comprar",
            json={
                "id": id_produto,
                "quantidade": qtd
            }
        )

        print(resposta.text)

    elif op == "4":

        id_produto = int(input("ID: "))
        nome = input("Nome: ")
        preco = float(input("Preco: "))
        quantidade = int(input("Quantidade: "))
        marca = input("Marca: ")

        resposta = requests.post(
            f"{URL}/produtos",
            json={
                "id": id_produto,
                "nome": nome,
                "preco": preco,
                "quantidade": quantidade,
                "marca": marca
            }
        )

        print(resposta.text)

    elif op == "0":
        break