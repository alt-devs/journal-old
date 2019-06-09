<template lang="pug">
  <profile-manager />
</template>

<script lang="ts">
import ProfileManager from '~/components/admin/ProfileManager'

export default {
  layout: 'admin',
  head() {
    return {
      title: this.$t('admin.menu.profile')
    }
  },
  components: {
    ProfileManager
  },

  async asyncData({ store, params }) {
    store.dispatch('admin/profile/fetchProfile')
    store.dispatch('admin/industries/fetchIndustries')
  }
}
</script>
