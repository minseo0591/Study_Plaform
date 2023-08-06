
//SIGNUP SWIPER
const signupSwiper = new Swiper(".signup .swiper-container", {
  slidesPerView: 1,
  loop: true,
  centeredSlides: true,
  observer: true,
  observeParents: true,
  autoplay: {
    delay: 1000,
   
  },
 
});
for (let i = 0; i < heroSwiper.pagination.bullets.length; i++) {
  heroSwiper.pagination.bullets[i].innerText = bannerLists[i];
}

