package com.parkingcontrol.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parkingcontrol.models.ParkingSpotModel;
import com.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {

	final ParkingSpotRepository parkingSpotRepository;

	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	// Save spot model in the database
	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) { 
		return parkingSpotRepository.save(parkingSpotModel);
	}

	// Check if given license plate is already registered
	public boolean existsByLicensePlateCar(String licensePlateCar) {
		return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
	}

	// Check if parking spot number is already registered
	public boolean existsByParkingSpotNumber(String parkingSpotNumber) { 
		return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	// Check if given apt/block already have a parking spot
	public boolean existsByApartamentAndBlock(String apartment, String block) { 
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	// Return all parking slots in the database
	public Page<ParkingSpotModel> findAll(Pageable pageable) { 
		return parkingSpotRepository.findAll(pageable);
	}

	// Return a specific parking slot via ID
	public Optional<ParkingSpotModel> findById(UUID id) { 
		return parkingSpotRepository.findById(id);
	}

	// Delete a specific parking slot via ID
	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) { 
		parkingSpotRepository.delete(parkingSpotModel);
	}
}
