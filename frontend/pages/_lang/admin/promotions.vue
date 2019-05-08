<template lang="pug">
  span promotions
</template>

<script lang="ts">
export default {
  layout: 'admin',
  head() {
    return {
      title: this.$t('admin.menu.promotions')
    }
  }
}
</script>
