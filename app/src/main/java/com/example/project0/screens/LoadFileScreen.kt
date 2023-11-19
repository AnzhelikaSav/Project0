package com.example.project0.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project0.R
import com.example.project0.ui.theme.Project0Theme

@Composable
fun LoadFileScreen(
    modifier: Modifier = Modifier,
    onClickJson: () -> Unit = {},
    onCLickXml: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilledTonalButton(
            onClick = { onClickJson() }
        ) {
            Text(text = stringResource(id = R.string.download_json))
        }
        FilledTonalButton(
            onClick = { onCLickXml() },
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text(text = stringResource(id = R.string.download_xml))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadFileScreenPreview() {
    Project0Theme {
        LoadFileScreen()
    }
}