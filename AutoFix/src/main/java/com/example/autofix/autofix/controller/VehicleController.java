package com.example.autofix.autofix.controller;


import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("API/Vehicle")
@CrossOrigin("*")
public class VehicleController {

    /* API endpoints */

    /* Service layer methods */

    @Autowired
    VehicleService vehicleService;

    /* GET OPERATIONS */

    /*--------------------------------------------------------------------------------------------------------
     * getVehicles: method to find all vehicles in the DB;
     *
     * @return - a list with all vehicles;
     --------------------------------------------------------------------------------------------------------*/

    @GetMapping("/")
    public List<VehicleEntity> getAllVehicles() {
        return (List<VehicleEntity>) vehicleService.getVehicles();

    }

    /*--------------------------------------------------------------------------------------------------------
     * getByPlate: method to find specific vehicle in DB by plate;
     *
     * @return - a vehicle with the specific plate;
     --------------------------------------------------------------------------------------------------------*/
    @GetMapping("/plate/{registrationPlate}")
    public VehicleEntity getVehicleByPlate(@PathVariable String registrationPlate) {
        return vehicleService.getByPlate(registrationPlate);
    }

    /* POST OPERATIONS */

    /*--------------------------------------------------------------------------------------------------------
     * createVehicle: method to find create a vehicle in the DB;
     *
     * @return - null;
     --------------------------------------------------------------------------------------------------------*/
    @PostMapping("/")
    public void createVehicle(@RequestBody VehicleEntity vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    /* UPDATE OPERATIONS */

    /*--------------------------------------------------------------------------------------------------------
     * updateVehicle: method to update a vehicle in the DB;
     *
     * @param id - the id of the vehicle to be updated;
     * @param updatedVehicle - the updated vehicle object;
     --------------------------------------------------------------------------------------------------------*/
    @PutMapping("/{id}")
    public void updateVehicle(@PathVariable Long id, @RequestBody VehicleEntity updatedVehicle) {
        updatedVehicle.setId(id); // Asegurar que el ID del vehículo actualizado sea el mismo que se pasa en la URL
        vehicleService.updateVehicle(updatedVehicle);
    }

    /*--------------------------------------------------------------------------------------------------------
     * updateVehicle: method to update a vehicle in the DB;
     *
     * @param updatedVehicle - the updated vehicle;
     --------------------------------------------------------------------------------------------------------*/
    @PutMapping("/")
    public void updateVehicle(@RequestBody VehicleEntity updatedVehicle) {
        vehicleService.updateVehicle(updatedVehicle);
    }

    /* DELETE OPERATIONS */

    /*--------------------------------------------------------------------------------------------------------
     * deleteVehicle: method to delete a vehicle in the DB;
     *
     * @param id - the id of the vehicle to delete;
     * @return - null
     --------------------------------------------------------------------------------------------------------*/
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }


}
