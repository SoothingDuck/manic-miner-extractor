#!/usr/bin/env python3

import pytest
from manic import ManicMinerFile

@pytest.fixture
def manic_miner_file():
    return ManicMinerFile()
