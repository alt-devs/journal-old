export const state = () => ({
  data: {
    name: '',
    slogan: '',
    industries: []
  }
})

export const mutations = {
  setProfile(state, profile) {
    state.data = profile
  },
  updateField(state, profile) {
    Object.assign(state.data, profile)
  },
  putProfile(state) {
    // TODO: send to the backend
    console.log(this.app.apolloProvider.defaultClient)
    state.data = {
      ...state.data,
      name: 'After update'
    }
  }
}

export const actions = {
  fetchProfile({ commit }) {
    commit('setProfile', {
      name: 'Цвети и пахни',
      slogan: 'Мы побреем и обвесим',
      industries: ['салоны красоты', 'здоровье', 'парикмахерские']
    })
  }
}

export const getters = {
  getProfile(store) {
    return store.data
  }
}
