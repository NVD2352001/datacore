package com.trucdulieu.commoncategory.service;

import com.trucdulieu.commoncategory.config.Constant;
import com.trucdulieu.commoncategory.model.converter.SupplierMapper;
import com.trucdulieu.commoncategory.model.dto.SupplierDto;
import com.trucdulieu.commoncategory.model.entity.Supplier;
import com.trucdulieu.commoncategory.reporsitory.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;

    public SupplierDto creat(SupplierDto req) {
        if (req.getId() != null)
            throw new RuntimeException(Constant.INVALID_INPUT);
        return modelMapper.map(supplierRepository.save(modelMapper.map(req, Supplier.class)), SupplierDto.class);
    }

    public SupplierDto update(SupplierDto req) {
        if (req.getId() == null)
            throw new RuntimeException(Constant.INVALID_INPUT);
        Optional<Supplier> op = supplierRepository.findById(req.getId());
        Supplier supplier = op.map(value -> SupplierMapper.forUpdate(value, req))
                .orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));
        return modelMapper.map(supplierRepository.save(supplier), SupplierDto.class);
    }

    public Boolean delete(Long id) {
        if(!supplierRepository.existsById(id))
            throw new RuntimeException(Constant.NOT_FOUND);
        supplierRepository.deleteById(id);
        return true;
    }

    public SupplierDto getById(Long id) {
        return supplierRepository.findById(id)
                .map(SupplierMapper::toDTO)
                .orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));
    }

    public List<SupplierDto> getAll() {
        return supplierRepository.findAll()
                .stream()
                .map(SupplierMapper::toDTO)
                .toList();
    }

    public Page<SupplierDto> findWithFilter(Long id, String name, String address, Pageable pageable) {
        return supplierRepository.findWithFilter(id, name, address, pageable).map(SupplierMapper::toDTO);
    }
}
