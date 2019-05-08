<template lang="pug">
  span clients
</template>

<script lang="ts">
export default {
  layout: 'admin',
  head() {
    return {
      title: this.$t('admin.menu.clients')
    }
  }
}
</script>
