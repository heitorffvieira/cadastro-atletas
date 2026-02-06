const containerForm = document.getElementById('container-form');
const containerEditForm = document.getElementById('container-edit-form');
const container = document.getElementById('container');
const athleteList = document.getElementById('athlete-list');

const API_URL = 'http://localhost:8080/athlete';

let athleteBeingEdited = null;

function openForm() {
    containerForm.style.display = 'grid';
    container.style.filter = 'blur(10px)';
}

function closeForm() {
    containerForm.style.display = 'none';
    container.style.filter = 'blur(0px)';
}

function closeEditForm() {
    containerEditForm.style.display = 'none';
    container.style.filter = 'blur(0px)';
    athleteBeingEdited = null;
}

window.onload = loadAthletes;

const nullMsg = document.getElementById('null-msg');

async function loadAthletes() {
    const response = await fetch(API_URL);
    const athletes = await response.json();

    athleteList.innerHTML = '';

    if (athletes.length === 0) {
        nullMsg.style.display = 'block';
        return;
    }

    nullMsg.style.display = 'none';

    athletes.forEach(addAthleteToList);
}


async function registerAthlete(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const age = document.getElementById('age').value;
    const shirtSize = document.getElementById('shirt-size').value;

    if (!name || !age || !shirtSize) {
        alert('Preencha todos os campos.');
        return;
    }

    const athlete = {
        name: name,
        age: Number(age),
        sizeShirt: shirtSize
    };

    await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(athlete)
    });

    closeForm();
    document.getElementById('athlete-form').reset();
    loadAthletes();
}

function addAthleteToList(athlete) {
    const athleteItem = document.createElement('li');
    athleteItem.classList.add('athlete-item');
    athleteItem.dataset.id = athlete.id;

    athleteItem.innerHTML = `
        <div class="information-athlete">
            <strong>Nome:</strong> <span class="athlete-name">${athlete.name}</span><br>
            <strong>Idade:</strong> <span class="athlete-age">${athlete.age}</span><br>
            <strong>Tamanho da Camisa:</strong> <span class="athlete-shirt">${athlete.sizeShirt}</span>
        </div>
        <div class="buttons-action">
            <button onclick="openEditForm(${athlete.id})">
                <img src="assets/edit.png" alt="Editar">
            </button>
            <button onclick="deleteAthlete(${athlete.id})">
                <img src="assets/trash.png" alt="Excluir">
            </button>
        </div>
    `;

    athleteList.appendChild(athleteItem);
}

async function openEditForm(id) {
    const response = await fetch(`${API_URL}/${id}`);
    const athlete = await response.json();

    athleteBeingEdited = id;

    document.getElementById('edit-name').value = athlete.name;
    document.getElementById('edit-age').value = athlete.age;
    document.getElementById('edit-shirt-size').value = athlete.sizeShirt;

    containerEditForm.style.display = 'grid';
    container.style.filter = 'blur(10px)';
}

async function saveEditedAthlete(event) {
    event.preventDefault();

    if (!athleteBeingEdited) return;

    const athlete = {
        name: document.getElementById('edit-name').value,
        age: Number(document.getElementById('edit-age').value),
        sizeShirt: document.getElementById('edit-shirt-size').value
    };

    await fetch(`${API_URL}/${athleteBeingEdited}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(athlete)
    });

    closeEditForm();
    loadAthletes();
}

async function deleteAthlete(id) {
    if (!confirm('Deseja realmente excluir este atleta?')) return;

    await fetch(`${API_URL}/${id}`, {
        method: 'DELETE'
    });

    loadAthletes();
}