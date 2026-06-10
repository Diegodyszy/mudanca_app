const usuario = JSON.parse (
  localStorage.getItem("usuariologado")
);

if (!usuario) {
  window.location.href = "../entrar_cadastrar/login.html";
}

document.getElementById("nomeUsuario")
.textContent = usuario.nome;

function logout() {
  localStorage.removeItem("usuariologado");
  window.location.href = "/frontend/paginicial/paginicial.html";
}

if(usuario.role === "ADMIN"){
  document
      .getElementById("painel-admin")
      .style.display = "block";

}