export const state = () => ({
  locales: ['en', 'ru'],
  locale: 'ru'
})

export const mutations = {
  setLocale(state, locale) {
    if (state.locales.indexOf(locale) !== -1) {
      state.locale = locale
    }
  }
}
