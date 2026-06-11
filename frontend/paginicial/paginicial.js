const usuario = JSON.parse (
  localStorage.getItem("usuariologado")
);

if (usuario) {
  document.getElementById("auth-buttons").style.display = "none";

  document.getElementById("usuario-info").style.display = "flex";
  document.getElementById("nomeUsuario").textContent = usuario.nome;
}

document.getElementById("btn-orcamento").addEventListener("click", function (e) {
  e.preventDefault();
  if (usuario) {
    window.location.href = "/frontend/Login/relacao.html";
  } else {
    window.location.href = "/frontend/entrar_cadastrar/login.html";
  }
});

function logout() {
    localStorage.removeItem("usuariologado");
    window.location.reload();
}

