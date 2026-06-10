const usuario = JSON.parse(localStorage.getItem("usuariologado"));

if (!usuario) {
  window.location.href = "../entrar_cadastrar/login.html";
}





const role = sessionStorage.getItem("role");
let usuariosCache = []; // Cache para armazenar os dados e exibir no modal

if (role !== "ADMIN") {
    alert("Acesso negado! Apenas administradores podem acessar esta página.");
    window.location.href = "../Login/login.html"; // ajuste o caminho
}

async function listaUsuarios(){
  try{
    const resposta = await fetch('http://localhost:8080/user');
    
    if (!resposta.ok) {
      throw new Error(`Erro no servidor: ${resposta.status}`);
    }

    const users = await resposta.json();
    usuariosCache = users; // Guarda a lista atualizada
    const corpoTabela = document.getElementById('corpoTabela');

    corpoTabela.innerHTML = "";

    if (users.length === 0) {
      corpoTabela.innerHTML = "<tr><td colspan='7' style='text-align:center'>Nenhum usuário cadastrado.</td></tr>";
    }

    users.forEach(usuario =>{
      corpoTabela.innerHTML += `
        <tr>
          <td>${usuario.nome}</td>
          <td>${usuario.telefone}</td>
          <td>${usuario.deEndereco}</td>
          <td>${usuario.paraEndereco}</td>
          <td>
            <span style="display: inline-block; max-width: 150px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; vertical-align: middle;">${usuario.relacao}</span>
            <button onclick="verRelacao(${usuario.id})" style="padding: 2px 8px; font-size: 12px; cursor: pointer; margin-left: 5px;">Ver tudo</button>
          </td>
          <td>${usuario.data}</td>
          <td>
            <button class="btn-excluir" onclick="deletarUsuario(${usuario.id})">Excluir</button>
          </td>
        </tr>
      `;
    })
  } catch (error){
    console.error("Erro ao listar usuários:", error);
    alert("Não foi possível carregar a lista de usuários. Verifique se o servidor backend está ligado.");
  }
}

// Função para abrir o modal com o texto completo
window.verRelacao = function(id) {
  const usuario = usuariosCache.find(u => u.id === id);
  if (!usuario) return;

  const modalHtml = `
    <div id="modalRelacao" style="position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.7); display:flex; justify-content:center; align-items:center; z-index:1000;">
      <div style="background:white; padding:20px; border-radius:10px; max-width:600px; width:90%; max-height:80vh; overflow-y:auto; box-shadow: 0 4px 15px rgba(0,0,0,0.3); font-family: Arial, sans-serif;">
        <h2 style="margin-top:0; color:#007bff; border-bottom: 1px solid #ddd; padding-bottom: 10px;">Relação de Itens</h2>
        <p style="white-space: pre-wrap; word-wrap: break-word; color:#333; line-height:1.6; margin-top: 15px;">${usuario.relacao}</p>
        <div style="text-align: right; margin-top: 20px; border-top: 1px solid #ddd; padding-top: 10px;">
          <button onclick="document.getElementById('modalRelacao').remove()" style="background:#6c757d; color:white; border:none; padding:8px 20px; border-radius:5px; cursor:pointer;">Fechar</button>
        </div>
      </div>
    </div>
  `;
  document.body.insertAdjacentHTML('beforeend', modalHtml);
}

async function deletarUsuario(id) {
  if (confirm("Tem certeza que deseja excluir este usuário?")) {
    try {
      await fetch(`http://localhost:8080/user/${id}`, { method: 'DELETE' });
      listaUsuarios(); // Recarrega a lista após excluir
    } catch (error) {
      console.error("Erro ao deletar:", error);
    }
  }
}

listaUsuarios();
