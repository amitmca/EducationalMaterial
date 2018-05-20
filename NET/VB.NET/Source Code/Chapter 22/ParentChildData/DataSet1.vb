﻿'------------------------------------------------------------------------------
' <autogenerated>
'     This code was generated by a tool.
'     Runtime Version: 1.1.4322.2032
'
'     Changes to this file may cause incorrect behavior and will be lost if 
'     the code is regenerated.
' </autogenerated>
'------------------------------------------------------------------------------

Option Strict Off
Option Explicit On

Imports System
Imports System.Data
Imports System.Runtime.Serialization
Imports System.Xml


<Serializable(),  _
 System.ComponentModel.DesignerCategoryAttribute("code"),  _
 System.Diagnostics.DebuggerStepThrough(),  _
 System.ComponentModel.ToolboxItem(true)>  _
Public Class DataSet1
    Inherits DataSet
    
    Private tablepublishers As publishersDataTable
    
    Private tabletitles As titlesDataTable
    
    Private relationpublisherstitles As DataRelation
    
    Public Sub New()
        MyBase.New
        Me.InitClass
        Dim schemaChangedHandler As System.ComponentModel.CollectionChangeEventHandler = AddressOf Me.SchemaChanged
        AddHandler Me.Tables.CollectionChanged, schemaChangedHandler
        AddHandler Me.Relations.CollectionChanged, schemaChangedHandler
    End Sub
    
    Protected Sub New(ByVal info As SerializationInfo, ByVal context As StreamingContext)
        MyBase.New
        Dim strSchema As String = CType(info.GetValue("XmlSchema", GetType(System.String)),String)
        If (Not (strSchema) Is Nothing) Then
            Dim ds As DataSet = New DataSet
            ds.ReadXmlSchema(New XmlTextReader(New System.IO.StringReader(strSchema)))
            If (Not (ds.Tables("publishers")) Is Nothing) Then
                Me.Tables.Add(New publishersDataTable(ds.Tables("publishers")))
            End If
            If (Not (ds.Tables("titles")) Is Nothing) Then
                Me.Tables.Add(New titlesDataTable(ds.Tables("titles")))
            End If
            Me.DataSetName = ds.DataSetName
            Me.Prefix = ds.Prefix
            Me.Namespace = ds.Namespace
            Me.Locale = ds.Locale
            Me.CaseSensitive = ds.CaseSensitive
            Me.EnforceConstraints = ds.EnforceConstraints
            Me.Merge(ds, false, System.Data.MissingSchemaAction.Add)
            Me.InitVars
        Else
            Me.InitClass
        End If
        Me.GetSerializationData(info, context)
        Dim schemaChangedHandler As System.ComponentModel.CollectionChangeEventHandler = AddressOf Me.SchemaChanged
        AddHandler Me.Tables.CollectionChanged, schemaChangedHandler
        AddHandler Me.Relations.CollectionChanged, schemaChangedHandler
    End Sub
    
    <System.ComponentModel.Browsable(false),  _
     System.ComponentModel.DesignerSerializationVisibilityAttribute(System.ComponentModel.DesignerSerializationVisibility.Content)>  _
    Public ReadOnly Property publishers As publishersDataTable
        Get
            Return Me.tablepublishers
        End Get
    End Property
    
    <System.ComponentModel.Browsable(false),  _
     System.ComponentModel.DesignerSerializationVisibilityAttribute(System.ComponentModel.DesignerSerializationVisibility.Content)>  _
    Public ReadOnly Property titles As titlesDataTable
        Get
            Return Me.tabletitles
        End Get
    End Property
    
    Public Overrides Function Clone() As DataSet
        Dim cln As DataSet1 = CType(MyBase.Clone,DataSet1)
        cln.InitVars
        Return cln
    End Function
    
    Protected Overrides Function ShouldSerializeTables() As Boolean
        Return false
    End Function
    
    Protected Overrides Function ShouldSerializeRelations() As Boolean
        Return false
    End Function
    
    Protected Overrides Sub ReadXmlSerializable(ByVal reader As XmlReader)
        Me.Reset
        Dim ds As DataSet = New DataSet
        ds.ReadXml(reader)
        If (Not (ds.Tables("publishers")) Is Nothing) Then
            Me.Tables.Add(New publishersDataTable(ds.Tables("publishers")))
        End If
        If (Not (ds.Tables("titles")) Is Nothing) Then
            Me.Tables.Add(New titlesDataTable(ds.Tables("titles")))
        End If
        Me.DataSetName = ds.DataSetName
        Me.Prefix = ds.Prefix
        Me.Namespace = ds.Namespace
        Me.Locale = ds.Locale
        Me.CaseSensitive = ds.CaseSensitive
        Me.EnforceConstraints = ds.EnforceConstraints
        Me.Merge(ds, false, System.Data.MissingSchemaAction.Add)
        Me.InitVars
    End Sub
    
    Protected Overrides Function GetSchemaSerializable() As System.Xml.Schema.XmlSchema
        Dim stream As System.IO.MemoryStream = New System.IO.MemoryStream
        Me.WriteXmlSchema(New XmlTextWriter(stream, Nothing))
        stream.Position = 0
        Return System.Xml.Schema.XmlSchema.Read(New XmlTextReader(stream), Nothing)
    End Function
    
    Friend Sub InitVars()
        Me.tablepublishers = CType(Me.Tables("publishers"),publishersDataTable)
        If (Not (Me.tablepublishers) Is Nothing) Then
            Me.tablepublishers.InitVars
        End If
        Me.tabletitles = CType(Me.Tables("titles"),titlesDataTable)
        If (Not (Me.tabletitles) Is Nothing) Then
            Me.tabletitles.InitVars
        End If
        Me.relationpublisherstitles = Me.Relations("publisherstitles")
    End Sub
    
    Private Sub InitClass()
        Me.DataSetName = "DataSet1"
        Me.Prefix = ""
        Me.Namespace = "http://www.tempuri.org/DataSet1.xsd"
        Me.Locale = New System.Globalization.CultureInfo("en-US")
        Me.CaseSensitive = false
        Me.EnforceConstraints = true
        Me.tablepublishers = New publishersDataTable
        Me.Tables.Add(Me.tablepublishers)
        Me.tabletitles = New titlesDataTable
        Me.Tables.Add(Me.tabletitles)
        Dim fkc As ForeignKeyConstraint
        fkc = New ForeignKeyConstraint("publisherstitles", New DataColumn() {Me.tablepublishers.pub_idColumn}, New DataColumn() {Me.tabletitles.pub_idColumn})
        Me.tabletitles.Constraints.Add(fkc)
        fkc.AcceptRejectRule = System.Data.AcceptRejectRule.None
        fkc.DeleteRule = System.Data.Rule.Cascade
        fkc.UpdateRule = System.Data.Rule.Cascade
        Me.relationpublisherstitles = New DataRelation("publisherstitles", New DataColumn() {Me.tablepublishers.pub_idColumn}, New DataColumn() {Me.tabletitles.pub_idColumn}, false)
        Me.Relations.Add(Me.relationpublisherstitles)
    End Sub
    
    Private Function ShouldSerializepublishers() As Boolean
        Return false
    End Function
    
    Private Function ShouldSerializetitles() As Boolean
        Return false
    End Function
    
    Private Sub SchemaChanged(ByVal sender As Object, ByVal e As System.ComponentModel.CollectionChangeEventArgs)
        If (e.Action = System.ComponentModel.CollectionChangeAction.Remove) Then
            Me.InitVars
        End If
    End Sub
    
    Public Delegate Sub publishersRowChangeEventHandler(ByVal sender As Object, ByVal e As publishersRowChangeEvent)
    
    Public Delegate Sub titlesRowChangeEventHandler(ByVal sender As Object, ByVal e As titlesRowChangeEvent)
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class publishersDataTable
        Inherits DataTable
        Implements System.Collections.IEnumerable
        
        Private columnpub_id As DataColumn
        
        Private columnpub_name As DataColumn
        
        Private columncity As DataColumn
        
        Private columnstate As DataColumn
        
        Private columncountry As DataColumn
        
        Friend Sub New()
            MyBase.New("publishers")
            Me.InitClass
        End Sub
        
        Friend Sub New(ByVal table As DataTable)
            MyBase.New(table.TableName)
            If (table.CaseSensitive <> table.DataSet.CaseSensitive) Then
                Me.CaseSensitive = table.CaseSensitive
            End If
            If (table.Locale.ToString <> table.DataSet.Locale.ToString) Then
                Me.Locale = table.Locale
            End If
            If (table.Namespace <> table.DataSet.Namespace) Then
                Me.Namespace = table.Namespace
            End If
            Me.Prefix = table.Prefix
            Me.MinimumCapacity = table.MinimumCapacity
            Me.DisplayExpression = table.DisplayExpression
        End Sub
        
        <System.ComponentModel.Browsable(false)>  _
        Public ReadOnly Property Count As Integer
            Get
                Return Me.Rows.Count
            End Get
        End Property
        
        Friend ReadOnly Property pub_idColumn As DataColumn
            Get
                Return Me.columnpub_id
            End Get
        End Property
        
        Friend ReadOnly Property pub_nameColumn As DataColumn
            Get
                Return Me.columnpub_name
            End Get
        End Property
        
        Friend ReadOnly Property cityColumn As DataColumn
            Get
                Return Me.columncity
            End Get
        End Property
        
        Friend ReadOnly Property stateColumn As DataColumn
            Get
                Return Me.columnstate
            End Get
        End Property
        
        Friend ReadOnly Property countryColumn As DataColumn
            Get
                Return Me.columncountry
            End Get
        End Property
        
        Public Default ReadOnly Property Item(ByVal index As Integer) As publishersRow
            Get
                Return CType(Me.Rows(index),publishersRow)
            End Get
        End Property
        
        Public Event publishersRowChanged As publishersRowChangeEventHandler
        
        Public Event publishersRowChanging As publishersRowChangeEventHandler
        
        Public Event publishersRowDeleted As publishersRowChangeEventHandler
        
        Public Event publishersRowDeleting As publishersRowChangeEventHandler
        
        Public Overloads Sub AddpublishersRow(ByVal row As publishersRow)
            Me.Rows.Add(row)
        End Sub
        
        Public Overloads Function AddpublishersRow(ByVal pub_id As String, ByVal pub_name As String, ByVal city As String, ByVal state As String, ByVal country As String) As publishersRow
            Dim rowpublishersRow As publishersRow = CType(Me.NewRow,publishersRow)
            rowpublishersRow.ItemArray = New Object() {pub_id, pub_name, city, state, country}
            Me.Rows.Add(rowpublishersRow)
            Return rowpublishersRow
        End Function
        
        Public Function FindBypub_id(ByVal pub_id As String) As publishersRow
            Return CType(Me.Rows.Find(New Object() {pub_id}),publishersRow)
        End Function
        
        Public Function GetEnumerator() As System.Collections.IEnumerator Implements System.Collections.IEnumerable.GetEnumerator
            Return Me.Rows.GetEnumerator
        End Function
        
        Public Overrides Function Clone() As DataTable
            Dim cln As publishersDataTable = CType(MyBase.Clone,publishersDataTable)
            cln.InitVars
            Return cln
        End Function
        
        Protected Overrides Function CreateInstance() As DataTable
            Return New publishersDataTable
        End Function
        
        Friend Sub InitVars()
            Me.columnpub_id = Me.Columns("pub_id")
            Me.columnpub_name = Me.Columns("pub_name")
            Me.columncity = Me.Columns("city")
            Me.columnstate = Me.Columns("state")
            Me.columncountry = Me.Columns("country")
        End Sub
        
        Private Sub InitClass()
            Me.columnpub_id = New DataColumn("pub_id", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnpub_id)
            Me.columnpub_name = New DataColumn("pub_name", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnpub_name)
            Me.columncity = New DataColumn("city", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columncity)
            Me.columnstate = New DataColumn("state", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnstate)
            Me.columncountry = New DataColumn("country", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columncountry)
            Me.Constraints.Add(New UniqueConstraint("Constraint1", New DataColumn() {Me.columnpub_id}, true))
            Me.columnpub_id.AllowDBNull = false
            Me.columnpub_id.Unique = true
        End Sub
        
        Public Function NewpublishersRow() As publishersRow
            Return CType(Me.NewRow,publishersRow)
        End Function
        
        Protected Overrides Function NewRowFromBuilder(ByVal builder As DataRowBuilder) As DataRow
            Return New publishersRow(builder)
        End Function
        
        Protected Overrides Function GetRowType() As System.Type
            Return GetType(publishersRow)
        End Function
        
        Protected Overrides Sub OnRowChanged(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowChanged(e)
            If (Not (Me.publishersRowChangedEvent) Is Nothing) Then
                RaiseEvent publishersRowChanged(Me, New publishersRowChangeEvent(CType(e.Row,publishersRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowChanging(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowChanging(e)
            If (Not (Me.publishersRowChangingEvent) Is Nothing) Then
                RaiseEvent publishersRowChanging(Me, New publishersRowChangeEvent(CType(e.Row,publishersRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowDeleted(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowDeleted(e)
            If (Not (Me.publishersRowDeletedEvent) Is Nothing) Then
                RaiseEvent publishersRowDeleted(Me, New publishersRowChangeEvent(CType(e.Row,publishersRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowDeleting(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowDeleting(e)
            If (Not (Me.publishersRowDeletingEvent) Is Nothing) Then
                RaiseEvent publishersRowDeleting(Me, New publishersRowChangeEvent(CType(e.Row,publishersRow), e.Action))
            End If
        End Sub
        
        Public Sub RemovepublishersRow(ByVal row As publishersRow)
            Me.Rows.Remove(row)
        End Sub
    End Class
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class publishersRow
        Inherits DataRow
        
        Private tablepublishers As publishersDataTable
        
        Friend Sub New(ByVal rb As DataRowBuilder)
            MyBase.New(rb)
            Me.tablepublishers = CType(Me.Table,publishersDataTable)
        End Sub
        
        Public Property pub_id As String
            Get
                Return CType(Me(Me.tablepublishers.pub_idColumn),String)
            End Get
            Set
                Me(Me.tablepublishers.pub_idColumn) = value
            End Set
        End Property
        
        Public Property pub_name As String
            Get
                Try 
                    Return CType(Me(Me.tablepublishers.pub_nameColumn),String)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tablepublishers.pub_nameColumn) = value
            End Set
        End Property
        
        Public Property city As String
            Get
                Try 
                    Return CType(Me(Me.tablepublishers.cityColumn),String)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tablepublishers.cityColumn) = value
            End Set
        End Property
        
        Public Property state As String
            Get
                Try 
                    Return CType(Me(Me.tablepublishers.stateColumn),String)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tablepublishers.stateColumn) = value
            End Set
        End Property
        
        Public Property country As String
            Get
                Try 
                    Return CType(Me(Me.tablepublishers.countryColumn),String)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tablepublishers.countryColumn) = value
            End Set
        End Property
        
        Public Function Ispub_nameNull() As Boolean
            Return Me.IsNull(Me.tablepublishers.pub_nameColumn)
        End Function
        
        Public Sub Setpub_nameNull()
            Me(Me.tablepublishers.pub_nameColumn) = System.Convert.DBNull
        End Sub
        
        Public Function IscityNull() As Boolean
            Return Me.IsNull(Me.tablepublishers.cityColumn)
        End Function
        
        Public Sub SetcityNull()
            Me(Me.tablepublishers.cityColumn) = System.Convert.DBNull
        End Sub
        
        Public Function IsstateNull() As Boolean
            Return Me.IsNull(Me.tablepublishers.stateColumn)
        End Function
        
        Public Sub SetstateNull()
            Me(Me.tablepublishers.stateColumn) = System.Convert.DBNull
        End Sub
        
        Public Function IscountryNull() As Boolean
            Return Me.IsNull(Me.tablepublishers.countryColumn)
        End Function
        
        Public Sub SetcountryNull()
            Me(Me.tablepublishers.countryColumn) = System.Convert.DBNull
        End Sub
        
        Public Function GettitlesRows() As titlesRow()
            Return CType(Me.GetChildRows(Me.Table.ChildRelations("publisherstitles")),titlesRow())
        End Function
    End Class
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class publishersRowChangeEvent
        Inherits EventArgs
        
        Private eventRow As publishersRow
        
        Private eventAction As DataRowAction
        
        Public Sub New(ByVal row As publishersRow, ByVal action As DataRowAction)
            MyBase.New
            Me.eventRow = row
            Me.eventAction = action
        End Sub
        
        Public ReadOnly Property Row As publishersRow
            Get
                Return Me.eventRow
            End Get
        End Property
        
        Public ReadOnly Property Action As DataRowAction
            Get
                Return Me.eventAction
            End Get
        End Property
    End Class
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class titlesDataTable
        Inherits DataTable
        Implements System.Collections.IEnumerable
        
        Private columntitle_id As DataColumn
        
        Private columntitle As DataColumn
        
        Private columntype As DataColumn
        
        Private columnpub_id As DataColumn
        
        Private columnprice As DataColumn
        
        Private columnadvance As DataColumn
        
        Private columnroyalty As DataColumn
        
        Private columnytd_sales As DataColumn
        
        Private columnnotes As DataColumn
        
        Private columnpubdate As DataColumn
        
        Friend Sub New()
            MyBase.New("titles")
            Me.InitClass
        End Sub
        
        Friend Sub New(ByVal table As DataTable)
            MyBase.New(table.TableName)
            If (table.CaseSensitive <> table.DataSet.CaseSensitive) Then
                Me.CaseSensitive = table.CaseSensitive
            End If
            If (table.Locale.ToString <> table.DataSet.Locale.ToString) Then
                Me.Locale = table.Locale
            End If
            If (table.Namespace <> table.DataSet.Namespace) Then
                Me.Namespace = table.Namespace
            End If
            Me.Prefix = table.Prefix
            Me.MinimumCapacity = table.MinimumCapacity
            Me.DisplayExpression = table.DisplayExpression
        End Sub
        
        <System.ComponentModel.Browsable(false)>  _
        Public ReadOnly Property Count As Integer
            Get
                Return Me.Rows.Count
            End Get
        End Property
        
        Friend ReadOnly Property title_idColumn As DataColumn
            Get
                Return Me.columntitle_id
            End Get
        End Property
        
        Friend ReadOnly Property titleColumn As DataColumn
            Get
                Return Me.columntitle
            End Get
        End Property
        
        Friend ReadOnly Property typeColumn As DataColumn
            Get
                Return Me.columntype
            End Get
        End Property
        
        Friend ReadOnly Property pub_idColumn As DataColumn
            Get
                Return Me.columnpub_id
            End Get
        End Property
        
        Friend ReadOnly Property priceColumn As DataColumn
            Get
                Return Me.columnprice
            End Get
        End Property
        
        Friend ReadOnly Property advanceColumn As DataColumn
            Get
                Return Me.columnadvance
            End Get
        End Property
        
        Friend ReadOnly Property royaltyColumn As DataColumn
            Get
                Return Me.columnroyalty
            End Get
        End Property
        
        Friend ReadOnly Property ytd_salesColumn As DataColumn
            Get
                Return Me.columnytd_sales
            End Get
        End Property
        
        Friend ReadOnly Property notesColumn As DataColumn
            Get
                Return Me.columnnotes
            End Get
        End Property
        
        Friend ReadOnly Property pubdateColumn As DataColumn
            Get
                Return Me.columnpubdate
            End Get
        End Property
        
        Public Default ReadOnly Property Item(ByVal index As Integer) As titlesRow
            Get
                Return CType(Me.Rows(index),titlesRow)
            End Get
        End Property
        
        Public Event titlesRowChanged As titlesRowChangeEventHandler
        
        Public Event titlesRowChanging As titlesRowChangeEventHandler
        
        Public Event titlesRowDeleted As titlesRowChangeEventHandler
        
        Public Event titlesRowDeleting As titlesRowChangeEventHandler
        
        Public Overloads Sub AddtitlesRow(ByVal row As titlesRow)
            Me.Rows.Add(row)
        End Sub
        
        Public Overloads Function AddtitlesRow(ByVal title_id As String, ByVal title As String, ByVal type As String, ByVal parentpublishersRowBypublisherstitles As publishersRow, ByVal price As Decimal, ByVal advance As Decimal, ByVal royalty As Integer, ByVal ytd_sales As Integer, ByVal notes As String, ByVal pubdate As Date) As titlesRow
            Dim rowtitlesRow As titlesRow = CType(Me.NewRow,titlesRow)
            rowtitlesRow.ItemArray = New Object() {title_id, title, type, parentpublishersRowBypublisherstitles(0), price, advance, royalty, ytd_sales, notes, pubdate}
            Me.Rows.Add(rowtitlesRow)
            Return rowtitlesRow
        End Function
        
        Public Function FindBytitle_id(ByVal title_id As String) As titlesRow
            Return CType(Me.Rows.Find(New Object() {title_id}),titlesRow)
        End Function
        
        Public Function GetEnumerator() As System.Collections.IEnumerator Implements System.Collections.IEnumerable.GetEnumerator
            Return Me.Rows.GetEnumerator
        End Function
        
        Public Overrides Function Clone() As DataTable
            Dim cln As titlesDataTable = CType(MyBase.Clone,titlesDataTable)
            cln.InitVars
            Return cln
        End Function
        
        Protected Overrides Function CreateInstance() As DataTable
            Return New titlesDataTable
        End Function
        
        Friend Sub InitVars()
            Me.columntitle_id = Me.Columns("title_id")
            Me.columntitle = Me.Columns("title")
            Me.columntype = Me.Columns("type")
            Me.columnpub_id = Me.Columns("pub_id")
            Me.columnprice = Me.Columns("price")
            Me.columnadvance = Me.Columns("advance")
            Me.columnroyalty = Me.Columns("royalty")
            Me.columnytd_sales = Me.Columns("ytd_sales")
            Me.columnnotes = Me.Columns("notes")
            Me.columnpubdate = Me.Columns("pubdate")
        End Sub
        
        Private Sub InitClass()
            Me.columntitle_id = New DataColumn("title_id", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columntitle_id)
            Me.columntitle = New DataColumn("title", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columntitle)
            Me.columntype = New DataColumn("type", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columntype)
            Me.columnpub_id = New DataColumn("pub_id", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnpub_id)
            Me.columnprice = New DataColumn("price", GetType(System.Decimal), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnprice)
            Me.columnadvance = New DataColumn("advance", GetType(System.Decimal), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnadvance)
            Me.columnroyalty = New DataColumn("royalty", GetType(System.Int32), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnroyalty)
            Me.columnytd_sales = New DataColumn("ytd_sales", GetType(System.Int32), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnytd_sales)
            Me.columnnotes = New DataColumn("notes", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnnotes)
            Me.columnpubdate = New DataColumn("pubdate", GetType(System.DateTime), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnpubdate)
            Me.Constraints.Add(New UniqueConstraint("Constraint1", New DataColumn() {Me.columntitle_id}, true))
            Me.columntitle_id.AllowDBNull = false
            Me.columntitle_id.Unique = true
            Me.columntitle.AllowDBNull = false
            Me.columntype.AllowDBNull = false
            Me.columnpubdate.AllowDBNull = false
        End Sub
        
        Public Function NewtitlesRow() As titlesRow
            Return CType(Me.NewRow,titlesRow)
        End Function
        
        Protected Overrides Function NewRowFromBuilder(ByVal builder As DataRowBuilder) As DataRow
            Return New titlesRow(builder)
        End Function
        
        Protected Overrides Function GetRowType() As System.Type
            Return GetType(titlesRow)
        End Function
        
        Protected Overrides Sub OnRowChanged(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowChanged(e)
            If (Not (Me.titlesRowChangedEvent) Is Nothing) Then
                RaiseEvent titlesRowChanged(Me, New titlesRowChangeEvent(CType(e.Row,titlesRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowChanging(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowChanging(e)
            If (Not (Me.titlesRowChangingEvent) Is Nothing) Then
                RaiseEvent titlesRowChanging(Me, New titlesRowChangeEvent(CType(e.Row,titlesRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowDeleted(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowDeleted(e)
            If (Not (Me.titlesRowDeletedEvent) Is Nothing) Then
                RaiseEvent titlesRowDeleted(Me, New titlesRowChangeEvent(CType(e.Row,titlesRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowDeleting(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowDeleting(e)
            If (Not (Me.titlesRowDeletingEvent) Is Nothing) Then
                RaiseEvent titlesRowDeleting(Me, New titlesRowChangeEvent(CType(e.Row,titlesRow), e.Action))
            End If
        End Sub
        
        Public Sub RemovetitlesRow(ByVal row As titlesRow)
            Me.Rows.Remove(row)
        End Sub
    End Class
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class titlesRow
        Inherits DataRow
        
        Private tabletitles As titlesDataTable
        
        Friend Sub New(ByVal rb As DataRowBuilder)
            MyBase.New(rb)
            Me.tabletitles = CType(Me.Table,titlesDataTable)
        End Sub
        
        Public Property title_id As String
            Get
                Return CType(Me(Me.tabletitles.title_idColumn),String)
            End Get
            Set
                Me(Me.tabletitles.title_idColumn) = value
            End Set
        End Property
        
        Public Property title As String
            Get
                Return CType(Me(Me.tabletitles.titleColumn),String)
            End Get
            Set
                Me(Me.tabletitles.titleColumn) = value
            End Set
        End Property
        
        Public Property type As String
            Get
                Return CType(Me(Me.tabletitles.typeColumn),String)
            End Get
            Set
                Me(Me.tabletitles.typeColumn) = value
            End Set
        End Property
        
        Public Property pub_id As String
            Get
                Try 
                    Return CType(Me(Me.tabletitles.pub_idColumn),String)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tabletitles.pub_idColumn) = value
            End Set
        End Property
        
        Public Property price As Decimal
            Get
                Try 
                    Return CType(Me(Me.tabletitles.priceColumn),Decimal)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tabletitles.priceColumn) = value
            End Set
        End Property
        
        Public Property advance As Decimal
            Get
                Try 
                    Return CType(Me(Me.tabletitles.advanceColumn),Decimal)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tabletitles.advanceColumn) = value
            End Set
        End Property
        
        Public Property royalty As Integer
            Get
                Try 
                    Return CType(Me(Me.tabletitles.royaltyColumn),Integer)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tabletitles.royaltyColumn) = value
            End Set
        End Property
        
        Public Property ytd_sales As Integer
            Get
                Try 
                    Return CType(Me(Me.tabletitles.ytd_salesColumn),Integer)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tabletitles.ytd_salesColumn) = value
            End Set
        End Property
        
        Public Property notes As String
            Get
                Try 
                    Return CType(Me(Me.tabletitles.notesColumn),String)
                Catch e As InvalidCastException
                    Throw New StrongTypingException("Cannot get value because it is DBNull.", e)
                End Try
            End Get
            Set
                Me(Me.tabletitles.notesColumn) = value
            End Set
        End Property
        
        Public Property pubdate As Date
            Get
                Return CType(Me(Me.tabletitles.pubdateColumn),Date)
            End Get
            Set
                Me(Me.tabletitles.pubdateColumn) = value
            End Set
        End Property
        
        Public Property publishersRow As publishersRow
            Get
                Return CType(Me.GetParentRow(Me.Table.ParentRelations("publisherstitles")),publishersRow)
            End Get
            Set
                Me.SetParentRow(value, Me.Table.ParentRelations("publisherstitles"))
            End Set
        End Property
        
        Public Function Ispub_idNull() As Boolean
            Return Me.IsNull(Me.tabletitles.pub_idColumn)
        End Function
        
        Public Sub Setpub_idNull()
            Me(Me.tabletitles.pub_idColumn) = System.Convert.DBNull
        End Sub
        
        Public Function IspriceNull() As Boolean
            Return Me.IsNull(Me.tabletitles.priceColumn)
        End Function
        
        Public Sub SetpriceNull()
            Me(Me.tabletitles.priceColumn) = System.Convert.DBNull
        End Sub
        
        Public Function IsadvanceNull() As Boolean
            Return Me.IsNull(Me.tabletitles.advanceColumn)
        End Function
        
        Public Sub SetadvanceNull()
            Me(Me.tabletitles.advanceColumn) = System.Convert.DBNull
        End Sub
        
        Public Function IsroyaltyNull() As Boolean
            Return Me.IsNull(Me.tabletitles.royaltyColumn)
        End Function
        
        Public Sub SetroyaltyNull()
            Me(Me.tabletitles.royaltyColumn) = System.Convert.DBNull
        End Sub
        
        Public Function Isytd_salesNull() As Boolean
            Return Me.IsNull(Me.tabletitles.ytd_salesColumn)
        End Function
        
        Public Sub Setytd_salesNull()
            Me(Me.tabletitles.ytd_salesColumn) = System.Convert.DBNull
        End Sub
        
        Public Function IsnotesNull() As Boolean
            Return Me.IsNull(Me.tabletitles.notesColumn)
        End Function
        
        Public Sub SetnotesNull()
            Me(Me.tabletitles.notesColumn) = System.Convert.DBNull
        End Sub
    End Class
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class titlesRowChangeEvent
        Inherits EventArgs
        
        Private eventRow As titlesRow
        
        Private eventAction As DataRowAction
        
        Public Sub New(ByVal row As titlesRow, ByVal action As DataRowAction)
            MyBase.New
            Me.eventRow = row
            Me.eventAction = action
        End Sub
        
        Public ReadOnly Property Row As titlesRow
            Get
                Return Me.eventRow
            End Get
        End Property
        
        Public ReadOnly Property Action As DataRowAction
            Get
                Return Me.eventAction
            End Get
        End Property
    End Class
End Class
