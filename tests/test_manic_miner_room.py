#!/usr/bin/env python3

import pytest

@pytest.mark.usefixtures("manic_miner_file")
@pytest.fixture
def central_cavern(manic_miner_file):
    room_list = list(manic_miner_file.rooms)
    return room_list[0]

@pytest.mark.usefixtures("manic_miner_file")
@pytest.fixture
def cold_room(manic_miner_file):
    room_list = list(manic_miner_file.rooms)
    return room_list[1]

def test_room_name(central_cavern, cold_room):
    assert central_cavern.name == "Central Cavern"
    assert cold_room.name == "The Cold Room"

@pytest.mark.usefixtures("manic_miner_file")
def test_exists_final_barrier(manic_miner_file):
    exist_final_barrier = False
    for room in manic_miner_file.rooms:
        if room.name == "The Final Barrier":
            exist_final_barrier = True

    assert exist_final_barrier
