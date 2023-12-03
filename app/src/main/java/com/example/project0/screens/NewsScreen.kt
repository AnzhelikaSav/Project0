package com.example.project0.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project0.R
import com.example.project0.models.NewModel
import com.example.project0.ui.theme.Project0Theme
import com.example.project0.utils.formatDate
import com.example.project0.utils.parseDate
import java.time.LocalDate

@Composable
fun NewsScreen(
    news: List<NewModel>,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxSize(),
    ) {
        var keyWord by remember { mutableStateOf("") }

        SearchTextField { word -> keyWord = word }
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val newsForShowing = if (keyWord == "") {
                news
            } else {
                news.filter { it.keywords.contains(keyWord) }
            }

            items(newsForShowing, key = { it.id }) {new ->
                NewItem(new = new)
            }
            item {
                FilledIconButton(
                    onClick = { onCloseClick() },
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .size(56.dp)
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(onDoneClick: (String) -> Unit) {

    var searchText by remember {
        mutableStateOf("")
    }

    TextField(
        value = searchText,
        onValueChange = { newValue -> searchText = newValue },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "",
                modifier = Modifier.clickable { onDoneClick(searchText) }
            )
        },
        placeholder = {
            Text(text = stringResource(id = R.string.search_placeholder))
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun NewItem(new: NewModel) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Text(
            text = new.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = new.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = formatDate(new.date),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    Project0Theme {
        NewsScreen(
            listOf(
                NewModel(
                    title = "Apple, IBM to bring iPads to 5 million Japanese seniors",
                    description = "An initiative between Apple, IBM and Japan Post Holdings could put iPads in the hands of up to 5 million members of Japan's elderly population.",
                    date = parseDate("2014-10-25 12:35:00 +0300")
                ),
                NewModel(
                    title = "New Chrome extension aims to protect Google passwords, foil phishers",
                    date = parseDate("2014-03-04 22:17:00 +0300")
                )
            ),
            {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewItemPreview() {
    Project0Theme {
        NewItem(
            NewModel(
                title = "Apple, IBM to bring iPads to 5 million Japanese seniors",
                date = parseDate("2014-10-25 12:35:00 +0300")
            )
        )
    }
}