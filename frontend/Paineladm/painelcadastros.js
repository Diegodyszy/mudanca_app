async function listaUsuarios(){
  try{
    const resposta = await fetch('http://localhost:8080/cadastro');
    
    if (!resposta.ok) {
      throw new Error(`Erro no servidor: ${resposta.status}`);
    }

    const users = await resposta.json();
    const corpoTabela = document.getElementById('corpoTabela');

    corpoTabela.innerHTML = "";

    if (users.length === 0) {
      corpoTabela.innerHTML = "<tr><td colspan='5' style='text-align:center'>Nenhum usuário cadastrado.</td></tr>";
    }

    users.forEach(usuario =>{
      corpoTabela.innerHTML += `
        <tr>
          <td>${usuario.email}</td>
          <td>${usuario.nome}</td>
          <td>${usuario.senha}</td>
          <td>${usuario.role}</td>
          <td>
            <button class="btn-excluir" onclick="deletarUsuario(${usuario.id})">Excluir</button>
            <button class="btn-role" onclick="alterarRole(${usuario.id})">Alterar Role</button>
          </td>

      `;
    })
  } catch (error){
    console.error("Erro ao listar usuários:", error);
    alert("Não foi possível carregar a lista de usuários. Verifique se o servidor backend está ligado.");
  }
}

window.deletarUsuario = async function(id) {
  if (confirm("Tem certeza que deseja excluir este usuário?")) {
    try {
      await fetch(`http://localhost:8080/cadastro/${id}`, { method: 'DELETE' });
      listaUsuarios();
    } catch (error) {
      console.error("Erro ao deletar:", error);
    }
  }
}

window.alterarRole = async function(id, novoRole) {
  try {
    const resposta = await fetch(`http://localhost:8080/cadastro/role/${id}?role=${novoRole}`, {
      method: 'PUT'
    });

    if (!resposta.ok) {
      throw new Error(`Erro: ${resposta.status}`);
    }

    listaUsuarios(); 
  } catch (error) {
    console.error("Erro ao alterar role:", error);
    alert("Não foi possível alterar o role do usuário.");
  }
}

listaUsuarios();



