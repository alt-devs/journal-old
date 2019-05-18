<template lang="pug">
  v-app
    v-navigation-drawer.sideMenu(
      :clipped="$vuetify.breakpoint.mdAndUp"
      :mini-variant.sync="isMenuMinified"
      v-model="isMenuShowed"
      fixed
      app
    )
      v-list.menuList
        v-list-tile(
          v-for="item in menuItems"
          :key="item.route"
          @click.stop="handleMenuItemGo(item)"
        )
          v-list-tile-action
            svg-icon.menuIcon(:name="item.icon")
          v-list-tile-content.menuText {{ item.text }}

    v-content
      v-container
        nuxt
    v-toolbar(
      :clipped-left="$vuetify.breakpoint.mdAndUp"
      color="green"
      dark
      app
      fixed
      flat
    )
      v-toolbar-side-icon(@click.stop="handleMenuActionToggle")
      nuxt-link(tag="div" to="/admin")
        div.companyLogo
          svg-icon(name="face-cream")

      h2.companyName Цвети и пахни
      div.currentPageCaption {{ currentCaption }}
      v-spacer

      div.userWrapper
        v-menu(bottom offset-y)
          template(v-slot:activator="{ on }")
            v-btn.userActionBtn(flat x-large v-on="on")
              span Елизавета Петровна
              div.userAvatar
                v-icon(dark x-large) person
          v-list
            v-list-tile(
              v-for="item in menuItems"
              :key="item.text"
              @click=""
            )
              v-list-tile-title {{ item.text }}


</template>

<script lang="ts">
import { Component, Vue, Emit, Watch } from 'vue-property-decorator'
import { oc } from 'ts-optchain'

const ADMIN_NAMESPACE = '/admin'


@Component
export default class AdminLayout extends Vue {
  isMenuMinified = false
  isMenuShowed = true
  currentCaption = ''

  @Watch('$route')
  onRouteChange(): void {
    this.setCurrentPageParams()
  }

  created(): void {
    this.setCurrentPageParams()
  }

  setCurrentPageParams(): void {
    const currentPath = this.$router.history.current.path

    if (currentPath) {
      const resource = `/${currentPath.split('/').pop()}`

      const foundMenuItem = this.menuItems.find(
        ({ route }) => route === resource
      )

      this.currentCaption = foundMenuItem ? foundMenuItem.text : ''
    }
  }

  public get menuItems() {
    return [
      {
        icon: 'brush',
        text: this.$t('admin.menu.services'),
        route: '/services'
      },
      {
        icon: 'specialists',
        text: this.$t('admin.menu.specialists'),
        route: '/specialists'
      },
      {
        icon: 'clients',
        text: this.$t('admin.menu.clients'),
        route: '/clients'
      },
      {
        icon: 'schedule',
        text: this.$t('admin.menu.schedule'),
        route: '/schedule'
      },
      {
        icon: 'promotions',
        text: this.$t('admin.menu.promotions'),
        route: '/promotions'
      },
      {
        icon: 'company',
        text: this.$t('admin.menu.profile'),
        route: '/profile'
      }
    ]
  }

  @Emit()
  handleMenuActionToggle(): void {
    if (this.$vuetify.breakpoint.lgAndUp) {
      this.isMenuMinified = !this.isMenuMinified
      !this.isMenuShowed && (this.isMenuShowed = true)
    } else {
      this.isMenuShowed = !this.isMenuShowed
      this.isMenuMinified && (this.isMenuMinified = false)
    }
  }

  @Emit()
  handleMenuItemGo({ route }): void {
    this.$router.push({ path: `${ADMIN_NAMESPACE}${route}` })
  }
}
</script>

<style lang="stylus" scoped>
$raised-shadow = 3px 0px 6px 0px $gray-400

.sideMenu
  box-shadow 3px 0px 6px 0px $gray-100

.menuList
  margin-top 15px
  display flex
  flex-direction column
  height calc(100% - 15px)
  min-height 300px
  overflow hidden

  > :last-child
    margin-top auto

.companyLogo
  height 68px
  width 68px
  margin 14px 15px 0 5px
  background-color $white
  border-radius 12px
  box-shadow $raised-shadow
  display flex
  align-items center
  justify-content center
  cursor pointer

  svg
    width 40px

.companyName
  text-transform uppercase
  font-size 20px

.currentPageCaption
  font-size 1.5em
  margin 0 30px

.menuIcon
  width 25px
  height 25px

.menuText
  text-transform uppercase

.userWrapper
  display flex
  align-items center
  height 100%

  .userActionBtn
    margin 0
    height 100%

  .userAvatar
    width 56px
    height 56px
    margin 0 10px
    border-radius 100%
    background-color $white
    box-shadow $raised-shadow
    display flex
    justify-content center
    vertical-align center
    color $black
</style>
