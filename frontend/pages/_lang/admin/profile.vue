<template lang="pug">
  span profile
</template>

<script lang="ts">
export default {
  layout: 'admin',
  head() {
    return {
      title: this.$t('admin.menu.profile')
    }
  }
}
</script>
