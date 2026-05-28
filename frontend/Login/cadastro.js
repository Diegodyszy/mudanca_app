const form = document.getElementById("formCadastro");

form.addEventListener("submit", function (event) {
    event.preventDefault(); // Impede o navegador de recarregar a página

    fetch("http://localhost:8080/user", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: nome.value,
            telefone: telefone.value,
            endereco: endereco.value,
            email: email.value,
        })
    })
    .then(res => {
        if (!res.ok) throw new Error("Erro ao salvar dados");
        return res.json();
    })
    .then(data => {
        console.log("Sucesso:", data);
        alert("Usuário cadastrado com sucesso!");
    })
    .catch(err => {
        console.error("Erro na conexão:", err);
        alert("Erro ao conectar com o servidor.");
    });
});
