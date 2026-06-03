const form = document.getElementById("formCadastro");

form.addEventListener("submit", function (event) {
    event.preventDefault(); // Impede o navegador de recarregar a página

    fetch("http://localhost:8080/cadastro", {
              headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
          nome : nome.value,
          senha : senha.value,
          email : email.value,
        })
  })
      .then(res => {
        if (!res.ok) throw new Error("Erro ao salvar dados");
        return res.json();
    })
    .then(data => {
        console.log("Sucesso:", data);
        window.location.href = "login.html";
    })
    .catch(err => {
        console.error("Erro na conexão:", err);
        alert("Erro ao conectar com o servidor.");
    });
});