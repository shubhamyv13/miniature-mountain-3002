const taskInput = document.getElementById('task-input');
const addBtn = document.getElementById('add-btn');
const updateBtn = document.getElementById('update-btn');
const cancelBtn = document.getElementById('cancel-btn');
const taskList = document.getElementById('task-list');

let tasks = [];
let editingTask = null;

addBtn.addEventListener('click', addTask);
updateBtn.addEventListener('click', updateTask);
cancelBtn.addEventListener('click', cancelTask);

function addTask(e) {
  e.preventDefault();
  const task = taskInput.value.trim();
  if (!task) return;
  tasks.push(task);
  renderTasks();
  taskInput.value = '';
}

function renderTasks() {
  taskList.innerHTML = '';
  tasks.forEach((task, index) => {
    const li = document.createElement('li');
    li.innerHTML = `<span>${task}</span><div><button onclick="editTask(${index})">Edit</button><button onclick="deleteTask(${index})">Delete</button></div>`;
    taskList.appendChild(li);
  });
}

function editTask(index) {
  editingTask = index;
  taskInput.value = tasks[index];
  addBtn.setAttribute('disabled', true);
  updateBtn.removeAttribute('disabled');
  cancelBtn.removeAttribute('disabled');
}

function updateTask(e) {
  e.preventDefault();
  const task = taskInput.value.trim();
  if (!task) return;
  tasks[editingTask] = task;
  editingTask = null;
  renderTasks();
  taskInput.value = '';
  addBtn.removeAttribute('disabled');
  updateBtn.setAttribute('disabled', true);
  cancelBtn.setAttribute('disabled', true);
}

function cancelTask(e) {
  e.preventDefault();
  editingTask = null;
  taskInput.value = '';
  addBtn.removeAttribute('disabled');
  updateBtn.setAttribute('disabled', true);
  cancelBtn.setAttribute('disabled', true);
}

function deleteTask(index) {
  tasks.splice(index, 1);
  renderTasks();
}
