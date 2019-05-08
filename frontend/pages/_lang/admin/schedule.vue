<template lang="pug">
  span schedule
</template>

<script lang="ts">
export default {
  layout: 'admin',
  head() {
    return {
      title: this.$t('admin.menu.schedule')
    }
  }
}
</script>
