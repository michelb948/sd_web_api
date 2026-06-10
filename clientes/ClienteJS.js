const readline = require("readline");

const URL = "http://localhost:8080/api";

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function menu() {

    console.log("\n=== ESTOQUE ===");
    console.log("1 - Listar produtos");
    console.log("2 - Buscar produto");
    console.log("3 - Comprar produto");
    console.log("4 - Adicionar produto");
    console.log("0 - Sair");

    rl.question("Opcao: ", async (op) => {

        if (op === "1") {

            const resposta =
                await fetch(`${URL}/produtos`);

            const dados =
                await resposta.json();

            console.log(dados);

            menu();
        }

        else if (op === "2") {

            rl.question("ID: ", async (id) => {

                const resposta =
                    await fetch(
                        `${URL}/produtos/${id}`
                    );

                const dados =
                    await resposta.json();

                console.log(dados);

                menu();
            });
        }

        else if (op === "3") {

            rl.question("ID: ", (id) => {

                rl.question("Quantidade: ", async (qtd) => {

                    const resposta =
                        await fetch(
                            `${URL}/comprar`,
                            {
                                method: "POST",
                                headers: {
                                    "Content-Type":
                                    "application/json"
                                },
                                body: JSON.stringify({
                                    id: parseInt(id),
                                    quantidade: parseInt(qtd)
                                })
                            }
                        );

                    const texto =
                        await resposta.text();

                    console.log(texto);

                    menu();
                });
            });
        }

        else if (op === "0") {

            rl.close();
        }
    });
}

menu();