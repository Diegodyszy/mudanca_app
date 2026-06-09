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
            deEndereco: endereco.value,
            paraEndereco: para_endereco.value,
            relacao: relacao.value,
            data: data.value
            
        })
    })
    .then(res => {
        if (!res.ok) throw new Error("Erro ao salvar dados");
        return res.json();
    })
    .then(data => {
        console.log("Sucesso:", data);
        alert("Suas informações foram salvas com sucesso, assim que possivel te retornaremos ");
    })
    .catch(err => {
        console.error("Erro na conexão:", err);
        alert("Erro ao conectar com o servidor.");
    });
});
