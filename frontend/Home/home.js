const role = sessionStorage.getItem("role");

// Se for admin, exibe o botão do painel administrativo
if (role === "ADMIN") {
    const painelAdmin = document.getElementById("painel-admin");
    if (painelAdmin) painelAdmin.style.display = "block";
}