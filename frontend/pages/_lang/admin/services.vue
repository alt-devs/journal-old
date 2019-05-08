<template lang="pug">
  span services
</template>

<script lang="ts">
export default {
  layout: 'admin',
  head() {
    return {
      title: this.$t('admin.menu.services')
    }
  }
}
</script>
