async function listaUsuarios(){
  try{
    const resposta = await fetch('http://localhost:8080/user');
    
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
          <td>${usuario.nome}</td>
          <td>${usuario.telefone}</td>
          <td>${usuario.endereco}</td>
          <td>${usuario.email}</td>
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
