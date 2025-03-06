package com.addressbook.service;

import com.springboot.addressbook.dto.AddressBookDTO;
import org.springframework.stereotype.Service;
import com.springboot.addressbook.model.AddressBook;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {
    private final List<AddressBook> addressBookList = new ArrayList<>();

    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }

    public AddressBook getEntryById(int id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public String addEntry(int id, AddressBookDTO dto) {
        AddressBook addressBook = new AddressBook(id, dto.getName());
        addressBookList.add(addressBook);
        return "Entry added successfully";
    }

    public String updateEntry(int id, AddressBookDTO dto) {
        for (AddressBook entry : addressBookList) {
            if (entry.getId() == id) {
                entry.setName(dto.getName());
                return "Entry updated successfully";
            }
        }
        return "Entry not found";
    }

    public String deleteEntry(int id) {
        for (AddressBook entry : addressBookList) {
            if (entry.getId() == id) {
                addressBookList.remove(entry);
                return "Entry deleted successfully";
            }
        }
        return "Entry not found";
    }
}
