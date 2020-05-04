parasails.registerPage('beecon', {
  //  ╦╔╗╔╦╔╦╗╦╔═╗╦    ╔═╗╔╦╗╔═╗╔╦╗╔═╗
  //  ║║║║║ ║ ║╠═╣║    ╚═╗ ║ ╠═╣ ║ ║╣
  //  ╩╝╚╝╩ ╩ ╩╩ ╩╩═╝  ╚═╝ ╩ ╩ ╩ ╩ ╚═╝
  data : {
     
    },
  //  ╦  ╦╔═╗╔═╗╔═╗╦ ╦╔═╗╦  ╔═╗
  //  ║  ║╠╣ ║╣ ║  ╚╦╝║  ║  ║╣
  //  ╩═╝╩╚  ╚═╝╚═╝ ╩ ╚═╝╩═╝╚═╝
  beforeMount: function() {

  },
  mounted: async function(){

  },
  //  ╦╔╗╔╔╦╗╔═╗╦═╗╔═╗╔═╗╔╦╗╦╔═╗╔╗╔╔═╗
  //  ║║║║ ║ ║╣ ╠╦╝╠═╣║   ║ ║║ ║║║║╚═╗
  //  ╩╝╚╝ ╩ ╚═╝╩╚═╩ ╩╚═╝ ╩ ╩╚═╝╝╚╝╚═╝
  methods: {
    addNewBeacon : function(){
      let name = $('#beeconName').val();
      let mac = $('#beeconMac').val();
      if (name != '' && mac != '') {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        const fetchOptions = {
          method: 'POST',
          headers: myHeaders,
          body:'{"nom": "' + name + '","addMac":"' + mac + '"}'
        }
        
        fetch("http://localhost:4910/beacons",fetchOptions)
        .then( (response) => {
          return response.json();
        })
        .then( (json) => {
          console.log(json);
          console.log('mac = '+mac);
          if (json.addMac == mac) {
            $("#message").html('<div class="alert alert-success alert-dismissible fade show" role="alert"><strong>Beecon ajouté</strong> Votre nouveau beecon a été enregistré et va être pris en compte dans quelques secondes<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
          }
          else{
            $("#message").html('<div class="alert alert-danger alert-dismissible fade show" role="alert"><strong>Une erreur est survenue</strong> Merci de vérifier vos champs et/ou de réessayer dans quelques secondes<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
          }
          $('.alert').alert();
          $('#modalAddBeecon').modal('hide');
          $('#beeconName').val('');
          $('#beeconMac').val('');
          setTimeout(function(){window.location.reload()},5000);
        }).catch( (error) => console.log(error))
        }
      
    }
  }
});
