export const state = () => ({
  data: []
})

export const mutations = {
  setIndustries(store, industries) {
    store.data = industries
  }
}

export const actions = {
  fetchIndustries({ commit }) {
    commit('setIndustries', [
      'салоны красоты',
      'здоровье',
      'парикмахерские',
      'обучение'
    ])
  }
}
