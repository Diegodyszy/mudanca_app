document.getElementById("formLogin").addEventListener("submit", function(event) {
    event.preventDefault();

    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    fetch("http://localhost:8080/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email: email, senha: senha })
    })
    .then(response => {
    if (response.ok) {
        response.json().then(usuario => {
            // Salva apenas o papel do usuário para as verificações de permissão
            sessionStorage.setItem("role", usuario.role);
            console.log("Usuário logado:", usuario);


            window.location.href = "../Home/home.html";
        });

        } else {
            // Usuário não existe → mostra mensagem
            alert("Usuário não existe!");
        }
    })
    .catch(error => {
        console.error("Erro:", error);
        alert("Erro ao conectar com o servidor.");
    });

});