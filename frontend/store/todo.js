export const state = () => ({
  list: []
})

export const mutations = {
  add(state, text) {
    // console.log(text)
    state.list.push({
      text: text,
      done: false
    })
  },
  remove(state, { todo }) {
    state.list.splice(state.list.indexOf(todo), 1)
  },
  toggle(state, todo) {
    todo.done = !todo.done
  },
  setTodos(state, todos) {
    console.log('set todos')
    todos.list = todos
  }
}

export const actions = {
  getTodos({ commit }) {
    console.log('get todos')

    commit('setTodos', [
      { text: 'newTodo', done: false },
      { text: 'anotherTodo', done: false }
    ])
  }
}
